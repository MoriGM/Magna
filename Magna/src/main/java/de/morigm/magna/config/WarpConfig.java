package de.morigm.magna.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.api.helper.FileHelper;
import lombok.Getter;
import lombok.Setter;

public class WarpConfig implements ConfigHelper
{

	@Getter @Setter private FileConfiguration config;
	public List<String> warps = new ArrayList<>();

	@Getter private File configFile = Magna.getFolders().getWarpsFile();

	@Override
	public void load() 
	{
		FileHelper.createFileIfNotExists(configFile);
		this.config = YamlConfiguration.loadConfiguration(configFile);
		if (this.config.isList("warps"))
			this.config.set("warps", null);
		for (String keys : this.config.getKeys(false))
			this.warps.add(keys);
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
