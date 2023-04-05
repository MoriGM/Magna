package de.morigm.magna.test;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StartTest {

    @Test
    public void PluginYmlExistsTest() {
        assertNotNull(ClassLoader.getSystemResourceAsStream("plugin.yml"));
    }

    @Test
    public void EnYmlExistsTest() {
        assertNotNull(ClassLoader.getSystemResourceAsStream("en-en.yml"));
    }

    @Test
    public void DeYmlExistsTest() {
        assertNotNull(ClassLoader.getSystemResourceAsStream("de-de.yml"));
    }

    @Test
    public void PermissionYMLExistsTest() {
        assertNotNull(ClassLoader.getSystemResourceAsStream("Permission.yml"));
    }

}
