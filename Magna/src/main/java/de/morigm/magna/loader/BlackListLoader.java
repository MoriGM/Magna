package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.censor.CensorType;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magna.api.saver.Saver;
import de.morigm.magna.api.utility.Permission;
import de.morigm.magna.config.BlackListConfig;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class BlackListLoader extends Permission implements Loader, Saver {

    @Getter
    private final List<BlackWord> blackWords = new ArrayList<>();

    @Override
    public void load() {
        for (String word : getBlackListConfig().getBlackwords()) {
            String permission = getConfig().contains(word + ".permission") ? getConfig().getString(word + ".permission")
                    : getPermission("blacklistword");
            CensorType type = getConfig().contains(word + ".type")
                    ? CensorType.getType(getConfig().getString(word + ".type"))
                    : CensorType.NORMAL;
            BlackWord bword = new BlackWord(word, permission, type);
            getBlackWords().add(bword);
        }
    }

    @Override
    public void save() {
        deleteConfig(getConfig());

        for (BlackWord word : getBlackWords()) {
            getConfig().set(word.word() + ".permission", word.permission());
            getConfig().set(word.word() + ".type", word.type().name());
        }
    }

    public void deleteConfig(FileConfiguration config) {
        for (String key : config.getKeys(true))
            config.set(key, null);
    }

    private FileConfiguration getConfig() {
        return Main.getInstance().getBlackListConfig().getConfig();
    }

    private BlackListConfig getBlackListConfig() {
        return Main.getInstance().getBlackListConfig();
    }

}
