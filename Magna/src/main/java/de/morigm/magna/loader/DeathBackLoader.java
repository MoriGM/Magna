package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.deathback.DeathBack;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magna.api.saver.Saver;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class DeathBackLoader implements Loader, Saver {

    @Getter
    private final List<DeathBack> deathBacks = new ArrayList<>();

    @Override
    public void load() {
        for (String key : getConfig().getKeys(false)) {
            String uuid = key;
            World world = Bukkit
                    .getWorld(Main.getInstance().getDeathBackConfig().getConfig().getString(key + ".world"));
            int x = getConfig().getInt(key + ".x");
            int y = getConfig().getInt(key + ".y");
            int z = getConfig().getInt(key + ".z");
            float yaw = (float) getConfig().getDouble(key + ".yaw");
            float pitch = (float) getConfig().getDouble(key + ".pitch");

            Location loc = new Location(world, x, y, z);
            loc.setPitch(pitch);
            loc.setYaw(yaw);

            DeathBack deathback = new DeathBack(uuid, loc);
            deathBacks.add(deathback);
        }
    }

    @Override
    public void save() {

        deleteConfig(getConfig());

        for (DeathBack db : getDeathBacks()) {
            getConfig().set(db.uuid() + ".x", db.location().getX());
            getConfig().set(db.uuid() + ".y", db.location().getY());
            getConfig().set(db.uuid() + ".z", db.location().getZ());
            getConfig().set(db.uuid() + ".yaw", db.location().getYaw());
            getConfig().set(db.uuid() + ".pitch", db.location().getPitch());
            getConfig().set(db.uuid() + ".world", db.location().getWorld().getName());
        }

    }

    public void deleteConfig(FileConfiguration config) {
        for (String key : config.getKeys(true))
            config.set(key, null);
    }

    private FileConfiguration getConfig() {
        return Main.getInstance().getDeathBackConfig().getConfig();
    }

}
