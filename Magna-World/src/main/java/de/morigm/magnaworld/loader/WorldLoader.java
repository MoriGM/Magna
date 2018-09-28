package de.morigm.magnaworld.loader;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.helper.LoadHelper;
import de.morigm.magnaworld.Main;
import de.morigm.magnaworld.api.world.WorldStruct;

public class WorldLoader implements LoadHelper
{
	
	@Override
	public void load() 
	{
		for(File f : Main.getInstance().getWorldFolder().listFiles())
		{
			FileConfiguration config = YamlConfiguration.loadConfiguration(f);
			if(!config.contains("name"))
				continue;
			String name = config.getString("name");
			WorldStruct ws = new WorldStruct(name);
		}
	}

}
