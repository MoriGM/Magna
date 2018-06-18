package de.morigm.magna.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;

public class PluginConfig implements ConfigHelper
{
	
	public List<String> commandspyblocked;
	public boolean owncommandspy;
	public boolean commandlog;
	public boolean chatclear;
	public List<String> groups;

	private void adddefault()
	{
		getConfig().options().copyDefaults(true);
		getConfig().addDefault("owncommandspy", false);
		getConfig().addDefault("commandlog", false);
		getConfig().addDefault("chatclear", false);
		getConfig().addDefault("commandspyblocked", new ArrayList<String>());
	}
	
	public void load()
	{
		this.adddefault();
		this.commandspyblocked = getConfig().getStringList("commandspyblocked");
		this.owncommandspy = getConfig().getBoolean("owncommandspy");
		this.commandlog = getConfig().getBoolean("commandlog");
		this.chatclear = getConfig().getBoolean("chatclear");
		this.groups = getConfig().getStringList("groups");
	}
	
	

	public void save()
	{
		getConfig().set("commandspyblocked", this.commandspyblocked);
		getConfig().set("owncommandspy", this.owncommandspy);
		getConfig().set("commandlog", this.commandlog);
		getConfig().set("chatclear", this.chatclear);
		getConfig().set("groups", this.groups);
		Main.getInstance().saveConfig();
	}
	
	public FileConfiguration getConfig()
	{
		return Main.getInstance().getConfig();
	}

}
