package de.morigm.magna.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.api.helper.FileHelper;
import lombok.SneakyThrows;

public class DeathBackConfig implements ConfigHelper 
{

	private File file;
	private FileConfiguration config;

	@Override
	public void load() 
	{
		this.file = new File(Main.getInstance().getDataFolder(),"deathback.yml");
		FileHelper.createFileIfNotExists(file);
		this.config = YamlConfiguration.loadConfiguration(file);
	}

	@SneakyThrows
	@Override
	public void save()
	{
		config.save(file);
	}
	
	public FileConfiguration getConfig() 
	{
		return config;
	}
	
	public File getFile() 
	{
		return file;
	}

}
