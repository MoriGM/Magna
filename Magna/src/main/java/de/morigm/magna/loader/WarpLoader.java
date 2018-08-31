package de.morigm.magna.loader;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.LoadHelper;
import de.morigm.magna.api.helper.SaveHelper;
import de.morigm.magna.api.warp.Warp;
import lombok.Getter;

public class WarpLoader implements LoadHelper,SaveHelper
{

	@Getter private List<Warp> warps;
	
	public WarpLoader() 
	{
		warps = new ArrayList<>();
	}
	
	@Override
	public void load() 
	{
		for(String w : Main.getInstance().getWarpConfig().warps)
		{
			World world = Bukkit.getWorld(Main.getInstance().getWarpConfig().getConfig().getString(w + ".world"));
			int x = getConfig().getInt(w + ".x");
			int y = getConfig().getInt(w + ".y");
			int z = getConfig().getInt(w + ".z");
			float yaw = (float) getConfig().getDouble(w + ".yaw");
			float pitch = (float) getConfig().getDouble(w + ".pitch");
			
			
			Location loc = new Location(world, x, y, z);
			loc.setPitch(pitch);
			loc.setYaw(yaw);
			String permission = getConfig().contains(w + ".permission") ? getConfig().getString(w + ".permission") : Main.getInstance().getPermissionManager().getPermission("warppermission");
			Warp warp = new Warp(w, permission, loc);
			warps.add(warp);
		}
	}

	@Override
	public void save()
	{
		deleteConfig(getConfig());
		
		for(Warp w : warps)
		{
			getConfig().set(w.name + ".x", w.location.getX());
			getConfig().set(w.name + ".y", w.location.getY());
			getConfig().set(w.name + ".z", w.location.getZ());
			getConfig().set(w.name + ".yaw", w.location.getYaw());
			getConfig().set(w.name + ".pitch", w.location.getPitch());
			getConfig().set(w.name + ".world", w.location.getWorld().getName());
			getConfig().set(w.name + ".permission", Main.getInstance().getPermissionManager().getPermission("warppermission") + "." + w.name);
		}
		
	}
	
	public void deleteConfig(FileConfiguration config)
	{
		for(String key : config.getKeys(true))
			config.set(key, null);
	}
	
	private FileConfiguration getConfig()
	{
		return Main.getInstance().getWarpConfig().getConfig();
	}
	
	
	

}
