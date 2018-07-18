package de.morigm.magna.api.manager;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.config.WarpConfig;

public class WarpManager
{
	public void setWarp(String name,Location loc)
	{
		if(!getWarpConfig().warps.contains(name))
			getWarpConfig().warps.add(name);
		getConfig().set(name + ".x", loc.getX());
		getConfig().set(name + ".y", loc.getY());
		getConfig().set(name + ".z", loc.getZ());
		getConfig().set(name + ".yaw", loc.getYaw());
		getConfig().set(name + ".pitch", loc.getPitch());
		getConfig().set(name + ".world", loc.getWorld().getName());
		getConfig().set(name + ".permission", Main.getInstance().getPermissionManager().getPermission("warppermission") + "." + name);
	}
	
	public void removeWarp(String name)
	{
		if(getWarpConfig().warps.contains(name))
			getWarpConfig().warps.remove(name);
		getConfig().set(name + ".x", null);
		getConfig().set(name + ".y", null);
		getConfig().set(name + ".z", null);
		getConfig().set(name + ".yaw", null);
		getConfig().set(name + ".pitch", null);
		getConfig().set(name + ".world", null);
		getConfig().set(name + ".permission", null);
		getConfig().set(name, null);
	}
	
	public Location getWarp(String name)
	{
		if(!this.containsWarp(name))
			return null;
	
		World world = Bukkit.getWorld(Main.getInstance().getWarpConfig().getConfig().getString(name + ".world"));
		int x = getConfig().getInt(name + ".x");
		int y = getConfig().getInt(name + ".y");
		int z = getConfig().getInt(name + ".z");
		float yaw = (float) getConfig().getDouble(name + ".yaw");
		float pitch = (float) getConfig().getDouble(name + ".pitch");
		
		
		Location loc = new Location(world, x, y, z);
		loc.setYaw(yaw);
		loc.setPitch(pitch);
		
		return loc;
	}
	
	public boolean WarpHasPermission(String name)
	{
		if(containsWarp(name))
			return getConfig().contains(name + ".permission");
		return false;
	}
	
	public String getPermissionFromWarp(String name)
	{
		return getConfig().getString(name + ".permission");
	}
	
	public boolean containsWarp(String name)
	{
		return getWarpConfig().warps.contains(name);
	}
	
	public List<String> getWarps()
	{
		return getWarpConfig().warps;
	}
	
	private FileConfiguration getConfig()
	{
		return Main.getInstance().getWarpConfig().getConfig();
	}
	
	private WarpConfig getWarpConfig()
	{
		return Main.getInstance().getWarpConfig();
	}
}
