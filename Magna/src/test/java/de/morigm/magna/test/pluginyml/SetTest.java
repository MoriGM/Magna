package de.morigm.magna.test.pluginyml;

import static org.junit.Assert.assertTrue;

import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.Test;

public class SetTest {

	@Test
	public void NameContains() {
		System.out.println("Test if Plugin Name is seted");
		FileConfiguration conf = YamlConfiguration
				.loadConfiguration(new InputStreamReader(ClassLoader.getSystemResourceAsStream("plugin.yml")));
		assertTrue(conf.contains("name"));
	}

	@Test
	public void VersionContains() {
		System.out.println("Test if Plugin Version is seted");
		FileConfiguration conf = YamlConfiguration
				.loadConfiguration(new InputStreamReader(ClassLoader.getSystemResourceAsStream("plugin.yml")));
		assertTrue(conf.contains("version"));
	}

	@Test
	public void AuthorContains() {
		System.out.println("Test if Plugin Author is seted");
		FileConfiguration conf = YamlConfiguration
				.loadConfiguration(new InputStreamReader(ClassLoader.getSystemResourceAsStream("plugin.yml")));
		assertTrue(conf.contains("author"));
	}

	@Test
	public void MainContains() {
		System.out.println("Test if Plugin Main is seted");
		FileConfiguration conf = YamlConfiguration
				.loadConfiguration(new InputStreamReader(ClassLoader.getSystemResourceAsStream("plugin.yml")));
		assertTrue(conf.contains("main"));
	}

}
