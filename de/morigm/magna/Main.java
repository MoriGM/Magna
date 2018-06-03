package de.morigm.magna;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.api.manager.CommandSpyManager;
import de.morigm.magna.api.manager.GodModeManager;
import de.morigm.magna.api.manager.MutedPlayerManager;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.config.PlayerConfig;
import de.morigm.magna.config.PluginConfig;
import de.morigm.magna.loader.PluginLoader;
import de.morigm.magna.log.CommandLoger;

public class Main extends JavaPlugin
{

	private static Main instance;
	
	private PluginLoader pluginLoader;
	
	private PermissionManager permissionManager;
	private MutedPlayerManager mutedPlayerManager;
	private GodModeManager godModeManager;
	private CommandSpyManager commandSpyManager;
	
	private PlayerConfig playerconfig;

	private PluginConfig pluginconfig;

	private CommandLoger commandsloger;

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		this.permissionManager = new PermissionManager();
		this.permissionManager.load();
		this.pluginLoader = new PluginLoader();
		this.pluginLoader.registerCommands();
		this.pluginLoader.registerListener();
		this.playerconfig = new PlayerConfig();
		this.playerconfig.load();
		this.mutedPlayerManager = new MutedPlayerManager();
		this.godModeManager = new  GodModeManager();
		this.commandSpyManager = new CommandSpyManager();
		this.pluginconfig = new PluginConfig();
		this.pluginconfig.load();
		this.commandsloger = new CommandLoger();
		this.commandsloger.load();
		Chat.writeMessage("Version: " + Chat.version);
		Chat.writeMessage("Plugin is started");
	}
	
	@Override
	public void onDisable() 
	{
		this.playerconfig.save();
		this.pluginconfig.save();
		this.commandsloger.save();
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
	
	public PlayerConfig getPlayerConfig()
	{
		return playerconfig;
	}
	
	public MutedPlayerManager getMutedPlayerManager()
	{
		return mutedPlayerManager;
	}
	
	public GodModeManager getGodModeManager()
	{
		return godModeManager;
	}
	
	public CommandSpyManager getCommandSpyManager() 
	{
		return commandSpyManager;
	}
	
	public PluginConfig getDefaultPluginConfig() 
	{
		return pluginconfig;
	}
	
}
