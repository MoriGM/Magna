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
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class WayPointConfig implements Config {

    public final List<AbstractMap.SimpleEntry<String, String>> waypoints = new ArrayList<>();
    @Getter
    private final File configFile = Magna.getFolders().getWaypointFolder();
    @Getter
    @Setter
    private FileConfiguration config;

    @Override
    public void load() {
        FileHelper.createFileIfNotExists(configFile);
        this.config = YamlConfiguration.loadConfiguration(configFile);
        if (this.config.isList("waypoints")) {
            this.config.set("waypoints", null);
        }
        for (String uuid : this.config.getKeys(false)) {
            for (String waypoint : this.config.getConfigurationSection(uuid).getKeys(false)) {
                waypoints.add(new AbstractMap.SimpleEntry<>(uuid, waypoint));
            }
        }
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
