package de.morigm.magna.api.manager;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.Main;

public class PermissionManager 
{
	private FileConfiguration configuration;

	public void load()
	{
		InputStream input = Main.getInstance().getResource("Permission.yml");
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
