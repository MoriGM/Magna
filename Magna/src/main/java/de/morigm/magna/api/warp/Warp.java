package de.morigm.magna.api.warp;

import org.bukkit.Location;

public class Warp 
{
	
	public String name, permission;
	public Location location;
	
	public Warp(String name,String Permission,Location location) 
	{
		this.name = name;
		this.permission = Permission;
		this.location = location;
	}
	
}
