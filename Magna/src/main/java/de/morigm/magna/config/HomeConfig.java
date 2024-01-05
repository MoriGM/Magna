package de.morigm.magna.config;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.config.Config;
import de.morigm.magna.api.utility.FileGenerator;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class HomeConfig implements Config {

    @Getter
    private YamlConfiguration config;

    @Override
    public void load() {
        File configFile = Magna.INSTANCE.getFolders().getHomeFile();
        FileGenerator.createFileIfNotExists(configFile);
        this.config = YamlConfiguration.loadConfiguration(configFile);

    }

    @SneakyThrows
    @Override
    public void save() {
        config.save(Magna.INSTANCE.getFolders().getHomeFile());
    }

}
