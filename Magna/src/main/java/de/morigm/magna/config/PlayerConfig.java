package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.config.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.util.List;

public class PlayerConfig implements Config {

    public List<String> muted, godmode, cmdspy;
    private FileConfiguration configuration;

    public void loadFile() {
        FileConfiguration conf = YamlConfiguration.loadConfiguration(Magna.getFolders().getPlayerFile());
        this.configuration = conf;
    }

    @Override
    public void load() {
        this.loadFile();
        this.muted = this.configuration.getStringList("muted");
        this.godmode = this.configuration.getStringList("godmode");
        this.cmdspy = this.configuration.getStringList("cmdspy");
    }

    @Override
    public void save() {
        this.configuration.set("muted", this.muted);
        this.configuration.set("godmode", this.godmode);
        this.configuration.set("cmdspy", this.cmdspy);
        try {
            this.configuration.save(Magna.getFolders().getPlayerFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
