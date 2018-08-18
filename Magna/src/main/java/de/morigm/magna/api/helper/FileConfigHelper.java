package de.morigm.magna.api.helper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class FileConfigHelper 
{
	
	public static void setLocation(FileConfiguration config,String name,Location loc)
	{
		config.set(name + ".x", loc.getX());
		config.set(name + ".y", loc.getY());
		config.set(name + ".z", loc.getZ());
		config.set(name + ".yaw", loc.getYaw());
		config.set(name + ".pitch", loc.getPitch());
		config.set(name + ".world", loc.getWorld().getName());
	}
	
	public static Location getLocation(FileConfiguration config,String name)
	{
		int x = config.getInt(name + ".x");
		int y = config.getInt(name + ".y");
		int z = config.getInt(name + ".z");
		float yaw = (float) config.getDouble(name + ".yaw");
		float pitch = (float) config.getDouble(name + ".pitch");
		World world = Bukkit.getWorld(config.getString(name + ".world"));
		Location loc = new Location(world, x, y, z);
		loc.setYaw(yaw);
		loc.setPitch(pitch);
		return loc;
	}
	
	public static void deleteConfig(FileConfiguration config)
	{
		for(String key : config.getKeys(true))
			config.set(key, null);
	}

}
