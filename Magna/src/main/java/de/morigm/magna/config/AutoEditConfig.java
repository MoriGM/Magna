package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.FileHelper;
import de.morigm.magna.api.loader.Loader;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class AutoEditConfig implements Loader {

    @Getter
    private FileConfiguration config;
    @Getter
    private FileConfiguration configPlayer;

    @Override
    public void load() {
        File file = Magna.getFolders().getAutoEditFile();
        FileHelper.createFileIfNotExists(file);
        this.config = YamlConfiguration.loadConfiguration(file);
        File filePlayer = Magna.getFolders().getPlayerAutoEditFile();
        FileHelper.createFileIfNotExists(filePlayer);
        this.configPlayer = YamlConfiguration.loadConfiguration(filePlayer);
    }

}
