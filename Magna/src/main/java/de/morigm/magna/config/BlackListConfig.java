package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.config.Config;
import de.morigm.magna.api.utility.FileGenerator;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BlackListConfig implements Config {

    @Getter
    private final List<String> blackwords = new ArrayList<>();
    @Getter
    private File file;
    @Getter
    private FileConfiguration config;

    @Override
    public void load() {
        File file = Magna.INSTANCE.getFolders().getBlackListFile();
        FileGenerator.createFileIfNotExists(file);
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        this.file = file;
        this.config = config;

        blackwords.addAll(getConfig().getKeys(false));
    }

    @SneakyThrows
    @Override
    public void save() {
        this.config.save(getFile());
    }

}
