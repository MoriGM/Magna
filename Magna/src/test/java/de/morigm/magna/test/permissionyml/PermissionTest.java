package de.morigm.magna.test.permissionyml;

import de.morigm.magna.api.Magna;
import de.morigm.magna.loader.PluginLoader;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class PermissionTest {
    @Test
    public void testYMLPermission() {
        CommandLoader loader = new CommandLoader();
        loader.registerCommands();
        List<String> permission = Magna.INSTANCE.getCommandUtil().getPermissions();
        FileConfiguration conf = YamlConfiguration
                .loadConfiguration(new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Permission.yml"))));
        for (String s : permission) {
            System.out.println("Test Permission:" + s);
            assertTrue(conf.contains(s));
        }
    }

    public static class CommandLoader extends PluginLoader {
        private boolean isactive = false;

        @Override
        public void registerCommands() {
            if (!isactive)
                super.registerCommands();
            isactive = true;
        }
    }
}
