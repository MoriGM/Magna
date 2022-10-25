package de.morigm.magna.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.FileConfigHelper;
import de.morigm.magna.api.helper.LoadHelper;
import de.morigm.magna.api.helper.SaveHelper;
import de.morigm.magna.api.home.Home;

public class HomeLoader implements LoadHelper, SaveHelper {

	public Map<UUID, List<Home>> player_home_map = new HashMap<>();

	@Override
	public void load() {
		for (String s : getConfig().getKeys(true)) {
			String[] args = s.replace('.', ',').split(",");
			if (args.length == 2) {
				UUID uuid = UUID.fromString(args[0]);
				String name = args[1];
				Location loc = FileConfigHelper.getLocation(getConfig(), uuid.toString() + "." + name);
				if (!player_home_map.containsKey(uuid))
					player_home_map.put(uuid, new ArrayList<Home>());
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
				FileConfigHelper.setLocation(getConfig(), uuid.toString() + "." + home.name, home.location);
		}
	}

	public static void deleteConfig(FileConfiguration config) {
		for (String key : config.getKeys(true))
			config.set(key, null);
	}

	public FileConfiguration getConfig() {
		return Main.getInstance().getHomeConfig().getConfig();
	}

}
