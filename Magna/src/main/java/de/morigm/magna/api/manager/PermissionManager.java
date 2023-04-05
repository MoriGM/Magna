package de.morigm.magna.api.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.InputStream;
import java.io.InputStreamReader;

public class PermissionManager {
    private final InputStream input;
    private FileConfiguration configuration;

    public PermissionManager(InputStream in) {
        this.input = in;
    }

    public void load() {
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(new InputStreamReader(input));
        this.configuration = configuration;
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public String getPermission(String Permission) {
        return configuration.getString(Permission);
    }

    public boolean hasPermission(String permission) {
        return configuration.contains(permission);
    }
}
