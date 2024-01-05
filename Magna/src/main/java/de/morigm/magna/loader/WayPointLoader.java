package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magna.api.saver.Saver;
import de.morigm.magna.api.waypoint.WayPoint;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class WayPointLoader implements Loader, Saver {

    @Getter
    private final List<WayPoint> WayPoints;

    public WayPointLoader() {
        this.WayPoints = new ArrayList<>();
    }

    @Override
    public void load() {
        for (AbstractMap.SimpleEntry<String, String> entry : Main.Companion.getInstance().getWaypointConfig().waypoints) {
            World world = Bukkit.getWorld(getConfig().getString(entry.getKey() + "." + entry.getValue() + ".world"));
            int x = getConfig().getInt(entry.getKey() + "." + entry.getValue() + ".x");
            int y = getConfig().getInt(entry.getKey() + "." + entry.getValue() + ".y");
            int z = getConfig().getInt(entry.getKey() + "." + entry.getValue() + ".z");

            Location loc = new Location(world, x, y, z);
            String permission = getConfig().contains(entry.getKey() + "." + entry.getValue() + ".permission")
                    ? getConfig().getString(entry.getKey() + "." + entry.getValue() + ".permission")
                    : Main.Companion.getInstance().getPermissionManager().getPermission("warppermission");
            WayPoint wayPoint = new WayPoint(entry.getValue(), entry.getKey(), permission, loc);
            this.WayPoints.add(wayPoint);
        }
    }

    @Override
    public void save() {
        deleteConfig(getConfig());

        for (WayPoint w : this.WayPoints) {
            getConfig().set(w.UUID + '.' + w.Name + ".x", w.Location.getX());
            getConfig().set(w.UUID + '.' + w.Name + ".y", w.Location.getY());
            getConfig().set(w.UUID + '.' + w.Name + ".z", w.Location.getZ());
            getConfig().set(w.UUID + '.' + w.Name + ".world", w.Location.getWorld().getName());
            getConfig().set(w.UUID + '.' + w.Name + ".permission",
                    Main.Companion.getInstance().getPermissionManager().getPermission("warppermission") + "." + w.Name);
        }
    }

    public void deleteConfig(FileConfiguration config) {
        for (String key : config.getKeys(true)) {
            config.set(key, null);
        }
    }

    private FileConfiguration getConfig() {
        return Main.Companion.getInstance().getWaypointConfig().getConfig();
    }

}
