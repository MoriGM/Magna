package de.morigm.magna.test.languageyml;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import de.morigm.magna.api.Magna;
import de.morigm.magna.loader.PluginLoader;

public class DeTest {
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
	public void testDeYml() throws IOException {
		System.out.println("Test De YML");
		CommandLoader loader = new CommandLoader();
		loader.registerCommands();
		List<String> translations = Magna.getCommandUtil().getTranslations();
		Properties prop = new Properties();
		prop.load(ClassLoader.getSystemResourceAsStream("de-de.yml"));
		for (String s : translations) {
			System.out.println("Test German Translation: " + s);
			assertTrue(prop.containsKey(s));
		}
	}

}
