package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.config.Config;
import de.morigm.magna.api.helper.FileHelper;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WarpConfig implements Config {

    public final List<String> warps = new ArrayList<>();
    @Getter
    private final File configFile = Magna.getFolders().getWarpsFile();
    @Getter
    @Setter
    private FileConfiguration config;

    @Override
    public void load() {
        FileHelper.createFileIfNotExists(configFile);
        this.config = YamlConfiguration.loadConfiguration(configFile);
        if (this.config.isList("warps")) {
            this.config.set("warps", null);
        }
        this.warps.addAll(this.config.getKeys(false));
    }

    @Override
    public void save() {
        try {
            FileHelper.createFileIfNotExists(configFile);
            this.config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
