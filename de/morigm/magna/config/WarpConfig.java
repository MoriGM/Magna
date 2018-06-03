package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.chat.Chat;

public class WarpConfig implements ConfigHelper
{

	private FileConfiguration config;
	public List<String> warps;

	@Override
	public void save() 
	{
		try
		{
			this.config.set("warps", this.warps);
			this.config.save(new File("./plugins/" + Chat.name + "/warps.yml"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void load() 
	{
		this.config = YamlConfiguration.loadConfiguration(new File("./plugins/" + Chat.name + "/warps.yml"));
		this.warps = this.config.getStringList("warps");
	}
	
	public FileConfiguration getConfig() 
	{
		return config;
	}

}
