package de.morigm.magna.config;

import java.util.ArrayList;
import java.util.List;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;

public class PluginConfig implements ConfigHelper
{
	
	public List<String> commandspyblocked;
	public boolean owncommandspy;

	private void adddefault()
	{
		Main.getInstance().getConfig().options().copyDefaults(true);
		Main.getInstance().getConfig().addDefault("owncommandspy", false);
		Main.getInstance().getConfig().addDefault("commandspyblocked", new ArrayList<String>());
	}
	
	public void load()
	{
		this.adddefault();
		this.commandspyblocked = Main.getInstance().getConfig().getStringList("commandspyblocked");
		this.owncommandspy = Main.getInstance().getConfig().getBoolean("owncommandspy");
	}
	
	

	public void save()
	{
		Main.getInstance().getConfig().set("commandspyblocked", this.commandspyblocked);
		Main.getInstance().getConfig().set("owncommandspy", this.owncommandspy);
		Main.getInstance().saveConfig();
	}

}
