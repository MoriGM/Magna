package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.config.Config;
import de.morigm.magna.api.helper.FileHelper;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class GroupConfig implements Config {

    private File file;
    private FileConfiguration config;

    @Override
    public void load() {
        this.file = Magna.getFolders().getGroupsFile();
        FileHelper.createFileIfNotExists(file);
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public void save() {
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public File getFile() {
        return file;
    }

}
