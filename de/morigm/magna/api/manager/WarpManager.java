package de.morigm.magna.api.manager;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import de.morigm.magna.Main;

public class WarpManager
{
	public void setWarp(String name,Location loc)
	{
		if(!Main.getInstance().getWarpConfig().warps.contains(name))
			Main.getInstance().getWarpConfig().warps.add(name);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".x", loc.getX());
		Main.getInstance().getWarpConfig().getConfig().set(name + ".y", loc.getY());
		Main.getInstance().getWarpConfig().getConfig().set(name + ".z", loc.getZ());
		Main.getInstance().getWarpConfig().getConfig().set(name + ".yaw", loc.getYaw());
		Main.getInstance().getWarpConfig().getConfig().set(name + ".pitch", loc.getPitch());
		Main.getInstance().getWarpConfig().getConfig().set(name + ".world", loc.getWorld().getName());
	}
	
	public void removeWarp(String name)
	{
		if(Main.getInstance().getWarpConfig().warps.contains(name))
			Main.getInstance().getWarpConfig().warps.remove(name);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".x", null);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".y", null);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".z", null);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".yaw", null);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".pitch", null);
		Main.getInstance().getWarpConfig().getConfig().set(name + ".world", null);
		Main.getInstance().getWarpConfig().getConfig().set(name, null);
	}
	
	public Location getWarp(String name)
	{
		if(!this.containsWarp(name))
			return null;
	
		World world = Bukkit.getWorld(Main.getInstance().getWarpConfig().getConfig().getString(name + ".world"));
		int x = Main.getInstance().getWarpConfig().getConfig().getInt(name + ".x");
		int y = Main.getInstance().getWarpConfig().getConfig().getInt(name + ".y");
		int z = Main.getInstance().getWarpConfig().getConfig().getInt(name + ".z");
		float yaw = (float) Main.getInstance().getWarpConfig().getConfig().getDouble(name + ".yaw");
		float pitch = (float) Main.getInstance().getWarpConfig().getConfig().getDouble(name + ".pitch");
		
		
		Location loc = new Location(world, x, y, z);
		loc.setYaw(yaw);
		loc.setPitch(pitch);
		
		return loc;
	}
	
	public boolean containsWarp(String name)
	{
		return Main.getInstance().getWarpConfig().warps.contains(name);
	}
	
	public List<String> getWarps()
	{
		return Main.getInstance().getWarpConfig().warps;
	}
}
