package de.morigm.magna.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.FileHelper;
import de.morigm.magna.api.helper.LoadHelper;
import lombok.Getter;

public class AutoEditConfig implements LoadHelper 
{

	@Getter private FileConfiguration config;
	private File file;
	@Getter private FileConfiguration configPlayer;
	private File filePlayer;
	
	@Override
	public void load() 
	{
		this.file = new File(Main.getInstance().getDataFolder(), "autoedit.yml");
		FileHelper.createFileIfNotExists(file);
		this.config = YamlConfiguration.loadConfiguration(file);
		this.filePlayer = new File(Main.getInstance().getDataFolder(), "playerautoedit.yml");
		FileHelper.createFileIfNotExists(filePlayer);
		this.configPlayer = YamlConfiguration.loadConfiguration(filePlayer);
	}

}
