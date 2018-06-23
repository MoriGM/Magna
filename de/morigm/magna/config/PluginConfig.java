package de.morigm.magna.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;

public class PluginConfig implements ConfigHelper
{
	
	public List<String> commandspyblocked;
	public boolean owncommandspy;
	public boolean commandlog;
	public boolean chatclear;
	public List<String> groups;
	public Location spawn;

	private void adddefault()
	{
		getConfig().options().copyDefaults(true);
		getConfig().addDefault("owncommandspy", false);
		getConfig().addDefault("commandlog", false);
		getConfig().addDefault("chatclear", false);
		getConfig().addDefault("commandspyblocked", new ArrayList<String>());
	}
	
	public void load()
	{
		this.adddefault();
		this.commandspyblocked = getConfig().getStringList("commandspyblocked");
		this.owncommandspy = getConfig().getBoolean("owncommandspy");
		this.commandlog = getConfig().getBoolean("commandlog");
		this.chatclear = getConfig().getBoolean("chatclear");
		this.groups = getConfig().getStringList("groups");
		
		loadSpawn();
	}
	
	

	private void loadSpawn() 
	{
		if(getConfig().contains("spawn.x") && getConfig().contains("spawn.y") && getConfig().contains("spawn.z") && 
				getConfig().contains("spawn.yaw") && getConfig().contains("spawn.pitch") && getConfig().contains("spawn.world"))
		{
			float pitch = (float) getConfig().getDouble("spawn.pitch");
			float yaw = (float) getConfig().getDouble("spawn.yaw");
			int x = getConfig().getInt("spawn.x");
			int y = getConfig().getInt("spawn.y");
			int z = getConfig().getInt("spawn.z");
			String world = getConfig().getString("spawn.world");
			
			Location loc = new Location(Bukkit.getWorld(world), x, y, z);
			loc.setYaw(yaw);
			loc.setPitch(pitch);
			
			this.spawn = loc;
		}
	}

	public void save()
	{
		savespawn();
		getConfig().set("commandspyblocked", this.commandspyblocked);
		getConfig().set("owncommandspy", this.owncommandspy);
		getConfig().set("commandlog", this.commandlog);
		getConfig().set("chatclear", this.chatclear);
		getConfig().set("groups", this.groups);
		Main.getInstance().saveConfig();
	}
	
	private void savespawn() 
	{
		getConfig().set("spawn.x", this.spawn.getBlockX());
		getConfig().set("spawn.y", this.spawn.getBlockY());
		getConfig().set("spawn.z", this.spawn.getBlockZ());
		getConfig().set("spawn.yaw", this.spawn.getYaw());
		getConfig().set("spawn.pitch", this.spawn.getPitch());
		getConfig().set("spawn.world", this.spawn.getWorld().getName());
	}

	public FileConfiguration getConfig()
	{
		return Main.getInstance().getConfig();
	}

}
