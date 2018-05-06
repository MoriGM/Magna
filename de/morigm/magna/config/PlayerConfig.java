package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.chat.Chat;

public class PlayerConfig
{
	
	private FileConfiguration configuration;
	public List<String> muted;
	public List<String> godmode;

	public void loadFile()
	{
		FileConfiguration conf = YamlConfiguration.loadConfiguration(new File("./plugins/" + Chat.name + "/players.yml"));
		this.configuration = conf;
	}
	
	public void load()
	{
		this.loadFile();
		this.muted = this.configuration.getStringList("muted");
		this.godmode = this.configuration.getStringList("godmode");
	}
	
	public void save()
	{
		this.configuration.set("muted", this.muted);
		this.configuration.set("godmode", this.godmode);
		try 
		{
			this.configuration.save(new File("./plugins/" + Chat.name + "/players.yml"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
