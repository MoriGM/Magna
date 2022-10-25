package de.morigm.magna.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.FileHelper;
import de.morigm.magna.api.helper.LoadHelper;
import lombok.Getter;

public class AutoEditConfig implements LoadHelper {

	@Getter
	private FileConfiguration config;
	private File file, filePlayer;
	@Getter
	private FileConfiguration configPlayer;

	@Override
	public void load() {
		this.file = Magna.getFolders().getAutoEditFile();
		FileHelper.createFileIfNotExists(file);
		this.config = YamlConfiguration.loadConfiguration(file);
		this.filePlayer = Magna.getFolders().getPlayerAutoEditFile();
		FileHelper.createFileIfNotExists(filePlayer);
		this.configPlayer = YamlConfiguration.loadConfiguration(filePlayer);
	}

}
