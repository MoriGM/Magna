package de.morigm.magna.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StartTest {

	@Test
	public void PluginYMLExistsTest() {
		assertTrue(ClassLoader.getSystemResourceAsStream("plugin.yml") != null);
	}

	@Test
	public void ENYMLExistsTest() {
		assertTrue(ClassLoader.getSystemResourceAsStream("en-en.yml") != null);
	}

	@Test
	public void DEYMLExistsTest() {
		assertTrue(ClassLoader.getSystemResourceAsStream("de-de.yml") != null);
	}

	@Test
	public void PermissionYMLExistsTest() {
		assertTrue(ClassLoader.getSystemResourceAsStream("Permission.yml") != null);
	}

}
