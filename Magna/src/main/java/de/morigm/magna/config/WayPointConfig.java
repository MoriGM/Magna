package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.api.helper.FileHelper;
import lombok.Getter;
import lombok.Setter;

public class WayPointConfig implements ConfigHelper
{

    @Getter @Setter private FileConfiguration config;
    public List<AbstractMap.SimpleEntry<String, String>> waypoints = new ArrayList<>();

    @Getter private final File configFile = Magna.getFolders().getWaypointFolder();

    @Override
    public void load()
    {
        FileHelper.createFileIfNotExists(configFile);
        this.config = YamlConfiguration.loadConfiguration(configFile);
        if (this.config.isList("waypoints")) {
            this.config.set("waypoints", null);
        }
        for(String uuid : this.config.getKeys(false)) {
            for(String waypoint : this.config.getConfigurationSection(uuid).getKeys(false)) {
                waypoints.add(new AbstractMap.SimpleEntry<>(uuid, waypoint));
            }
        }
    }

    @Override
    public void save()
    {
        try
        {
            FileHelper.createFileIfNotExists(configFile);
            this.config.save(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
