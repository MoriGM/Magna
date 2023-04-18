package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.config.FileConfig;
import de.morigm.magna.api.home.Home;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magna.api.saver.Saver;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class HomeLoader implements Loader, Saver {

    public final Map<UUID, List<Home>> player_home_map = new HashMap<>();

    public static void deleteConfig(FileConfiguration config) {
        for (String key : config.getKeys(true))
            config.set(key, null);
    }

    @Override
    public void load() {
        for (String s : getConfig().getKeys(true)) {
            String[] args = s.replace('.', ',').split(",");
            if (args.length == 2) {
                UUID uuid = UUID.fromString(args[0]);
                String name = args[1];
                Location loc = FileConfig.getLocation(getConfig(), uuid + "." + name);
                if (!player_home_map.containsKey(uuid))
                    player_home_map.put(uuid, new ArrayList<>());
                List<Home> homes = player_home_map.get(uuid);
                homes.add(new Home(name, loc));
                player_home_map.put(uuid, homes);
            }
        }
    }

    @Override
    public void save() {
        deleteConfig(getConfig());

        for (UUID uuid : player_home_map.keySet()) {
            List<Home> homes = player_home_map.get(uuid);
            for (Home home : homes)
                FileConfig.setLocation(getConfig(), uuid.toString() + "." + home.name(), home.location());
        }
    }

    public FileConfiguration getConfig() {
        return Main.getInstance().getHomeConfig().getConfig();
    }

}
