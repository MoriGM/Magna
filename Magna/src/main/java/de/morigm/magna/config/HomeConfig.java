package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.ConfigHelper;
import de.morigm.magna.api.helper.FileHelper;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class HomeConfig implements ConfigHelper {

	@Getter
	private YamlConfiguration config;

	@Override
	public void load() {
		File configFile = Magna.getFolders().getHomeFile();
		FileHelper.createFileIfNotExists(configFile);
		this.config = YamlConfiguration.loadConfiguration(configFile);

	}

	@SneakyThrows
	@Override
	public void save() {
		config.save(Magna.getFolders().getHomeFile());
	}

}
