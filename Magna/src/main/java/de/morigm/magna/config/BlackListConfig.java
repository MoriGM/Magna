package de.morigm.magna.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.api.helper.FileHelper;
import lombok.Getter;
import lombok.SneakyThrows;

public class BlackListConfig implements ConfigHelper
{

	@Getter private File file;
	@Getter private FileConfiguration config;
	@Getter private List<String> blackwords = new ArrayList<>();

	@Override
	public void load()
	{
		File file = Magna.getFolders().getBlackListFile();
		FileHelper.createFileIfNotExists(file);
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		this.file = file;
		this.config = config;
		
		for(String key : getConfig().getKeys(false))
			blackwords.add(key);
	}

	@SneakyThrows
	@Override
	public void save()
	{
		this.config.save(getFile());
	}

}
