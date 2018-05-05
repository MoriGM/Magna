package de.morigm.magna;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.chat.Chat;

public class Main extends JavaPlugin
{

	private static Main instance;

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		Chat.writeMessage("Plugin is started");
	}
	
	@Override
	public void onDisable() 
	{
		Chat.writeMessage("Plugin is stopped");
	}
	
	public static Main getInstance() 
	{
		return instance;
	}
	
}
