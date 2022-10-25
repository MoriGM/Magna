package de.morigm.magna.test.permissionyml;

import static org.junit.Assert.assertTrue;

import java.io.InputStreamReader;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.Test;

import de.morigm.magna.api.Magna;
import de.morigm.magna.loader.PluginLoader;

public class PermissionTest {
	public class CommandLoader extends PluginLoader {
		private boolean isactive = false;

		@Override
		public void registerCommands() {
			if (!isactive)
				super.registerCommands();
			isactive = true;
		}
	}

	@Test
	public void testYMLPermission() {
		CommandLoader loader = new CommandLoader();
		loader.registerCommands();
		List<String> permission = Magna.getCommandUtil().getPermissions();
		FileConfiguration conf = YamlConfiguration
				.loadConfiguration(new InputStreamReader(ClassLoader.getSystemResourceAsStream("Permission.yml")));
		for (String s : permission) {
			System.out.println("Test Permission:" + s);
			assertTrue(conf.contains(s));
		}
	}
}
