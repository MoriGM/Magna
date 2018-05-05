package de.morigm.magna;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.loader.PluginLoader;

public class Main extends JavaPlugin
{

	private static Main instance;
	private PermissionManager permissionManager;
	private PluginLoader pluginLoader;

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		this.permissionManager = new PermissionManager();
		this.permissionManager.load();
		this.pluginLoader = new PluginLoader();
		this.pluginLoader.registerCommands();
		this.pluginLoader.registerListener();
		Chat.writeMessage("Version: " + Chat.version);
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
	
	public PermissionManager getPermissionManager() 
	{
		return permissionManager;
	}
	
}
