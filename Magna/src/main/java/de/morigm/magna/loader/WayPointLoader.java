package de.morigm.magna.loader;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import de.morigm.magna.api.waypoint.WayPoint;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.LoadHelper;
import de.morigm.magna.api.helper.SaveHelper;
import lombok.Getter;

public class WayPointLoader implements LoadHelper, SaveHelper {

	@Getter
	private final List<WayPoint> WayPoints;

	public WayPointLoader() {
		this.WayPoints = new ArrayList<>();
	}

	@Override
	public void load() {
		for (AbstractMap.SimpleEntry<String, String> entry : Main.getInstance().getWaypointConfig().waypoints) {
			World world = Bukkit.getWorld(getConfig().getString(entry.getKey() + "." + entry.getValue() + ".world"));
			int x = getConfig().getInt(entry.getKey() + "." + entry.getValue() + ".x");
			int y = getConfig().getInt(entry.getKey() + "." + entry.getValue() + ".y");
			int z = getConfig().getInt(entry.getKey() + "." + entry.getValue() + ".z");

			Location loc = new Location(world, x, y, z);
			String permission = getConfig().contains(entry.getKey() + "." + entry.getValue() + ".permission")
					? getConfig().getString(entry.getKey() + "." + entry.getValue() + ".permission")
					: Main.getInstance().getPermissionManager().getPermission("warppermission");
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
					Main.getInstance().getPermissionManager().getPermission("warppermission") + "." + w.Name);
		}
	}

	public void deleteConfig(FileConfiguration config) {
		for (String key : config.getKeys(true)) {
			config.set(key, null);
		}
	}

	private FileConfiguration getConfig() {
		return Main.getInstance().getWaypointConfig().getConfig();
	}

}
