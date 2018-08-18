package de.morigm.magna.api.manager;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PermissionManager 
{
	private FileConfiguration configuration;
	private InputStream input;
	
	public PermissionManager(InputStream in) 
	{
		this.input = in;
	}

	public void load()
	{
		FileConfiguration configuration = YamlConfiguration.loadConfiguration(new InputStreamReader(input));
		this.configuration = configuration;
	}
	
	public FileConfiguration getConfiguration() 
	{
		return configuration;
	}
	
	public String getPermission(String Permission)
	{
		return configuration.getString(Permission);
	}
}
