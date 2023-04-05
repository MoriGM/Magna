package de.morigm.magnaworld.loader;

import de.morigm.magna.api.helper.SaveHelper;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magnaworld.Main;
import de.morigm.magnaworld.api.MagnaWorld;
import de.morigm.magnaworld.api.world.WorldStruct;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class WorldLoader implements Loader, SaveHelper {

    @Override
    public void load() {
        for (File f : Main.getInstance().getWorldFolder().listFiles()) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(f);
            if (!config.contains("name"))
                continue;
            String name = config.getString("name");
            WorldStruct ws = new WorldStruct(name);
            MagnaWorld.loadWorld(ws);
        }
    }

    @SneakyThrows
    @Override
    public void save() {
        for (File f : Main.getInstance().getWorldFolder().listFiles())
            f.delete();
        for (WorldStruct world : MagnaWorld.getWorlds()) {
            File file = new File(Main.getInstance().getWorldFolder(), world.getName() + ".yml");
            if (!file.exists())
                file.createNewFile();
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("name", world.getName());
            config.save(file);
        }

    }

}
