package de.morigm.magna.api.manager;

import java.util.List;

import org.bukkit.Location;

import de.morigm.magna.Main;
import de.morigm.magna.api.warp.Warp;
import de.morigm.magna.loader.WarpLoader;

public class WarpManager
{
	public void setWarp(String name,Location loc)
	{
		Warp w = new Warp(name, Main.getInstance().getPermissionManager().getPermission("warppermission"), loc);
		if(!containsWarp(w.name))
			getWarps().add(w);
	}
	
	public void removeWarp(String name)
	{
		if(containsWarp(name))
			getWarps().remove(getWarp(name));
	}
	
	public Location getWarpLocation(String name)
	{
		for(Warp w : getWarps())
			if(w.name.equals(name))
				return w.location;
			
		return null;
	}
	
	public Warp getWarp(String name)
	{
		for(Warp w : getWarps())
			if(w.name.equals(name))
				return w;
		return null;
	}
	
	public boolean WarpHasPermission(String name)
	{
		return getPermissionFromWarp(name) != null;
	}
	
	public String getPermissionFromWarp(String name)
	{
		for(Warp w : Main.getInstance().getWarpLoader().getWarps())
			if(w.name.equals(name))
				return w.permission;
		return null;
	}
	
	public boolean containsWarp(String name)
	{
		for(Warp w : Main.getInstance().getWarpLoader().getWarps())
			if(w.name.equals(name))
				return true;
		return false;
	}
	
	public List<Warp> getWarps()
	{
		return getWarpLoader().getWarps();
	}
	
	private WarpLoader getWarpLoader()
	{
		return Main.getInstance().getWarpLoader();
	}
}
