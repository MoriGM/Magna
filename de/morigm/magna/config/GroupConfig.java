package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.chat.Chat;

public class GroupConfig implements ConfigHelper
{

	private File file;
	private FileConfiguration config;

	@Override
	public void load() 
	{
		this.file = new File("./plugins/" + Chat.name + "/groups.yml");
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		this.config = YamlConfiguration.loadConfiguration(file);
	}

	@Override
	public void save() {}
	
	public FileConfiguration getConfig() 
	{
		return config;
	}
	
	public File getFile() 
	{
		return file;
	}

}
