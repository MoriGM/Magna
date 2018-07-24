package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.api.helper.FileHelper;
import lombok.Getter;
import lombok.Setter;

public class WarpConfig implements ConfigHelper
{

	@Getter @Setter private FileConfiguration config;
	public List<String> warps;

	@Getter private File configFile = new File(Main.getInstance().getDataFolder(),"/warps.yml");

	@Override
	public void load() 
	{
		FileHelper.createFileIfNotExists(configFile);
		this.config = YamlConfiguration.loadConfiguration(configFile);
		this.warps = this.config.getStringList("warps");
	}
	
	@Override
	public void save() 
	{
		try
		{
			FileHelper.createFileIfNotExists(configFile);
			this.config.save(configFile);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
