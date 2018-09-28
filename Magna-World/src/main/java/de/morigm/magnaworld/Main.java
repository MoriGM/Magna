package de.morigm.magnaworld;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public class Main extends JavaPlugin
{
	
	@Getter private static Main instance;
	@Getter private File folder;
	@Getter private File WorldFolder;

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		this.folder = getDataFolder();
		this.WorldFolder = new File(folder, "worlds");
	}
	
	@Override
	public void onDisable() 
	{
	}
}
