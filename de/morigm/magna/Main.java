package de.morigm.magna;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.api.manager.CommandSpyManager;
import de.morigm.magna.api.manager.GodModeManager;
import de.morigm.magna.api.manager.GroupManager;
import de.morigm.magna.api.manager.MutedPlayerManager;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.manager.WarpManager;
import de.morigm.magna.api.memorie.MemorieManager;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.config.GroupConfig;
import de.morigm.magna.config.PlayerConfig;
import de.morigm.magna.config.PluginConfig;
import de.morigm.magna.config.WarpConfig;
import de.morigm.magna.loader.GroupLoader;
import de.morigm.magna.loader.LanguageLoader;
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
	private WarpManager warpmanager;
	private MemorieManager memorieManager;
	private GroupManager groupManager;
	
	private PlayerConfig playerconfig;
	private PluginConfig pluginconfig;
	private WarpConfig warpconfig;
	private GroupConfig groupconfig;
	
	private CommandLoger commandsloger;

	private GroupLoader grouploader;
	
	private File languageFolder = new File(getDataFolder(),"languages");
	private File jar;
			
	private LanguageLoader LanguageLoader;
	

	@Override
	public void onEnable() 
	{
		jar = this.getFile();
		Main.instance = this;
		this.LanguageLoader = new LanguageLoader();
		LanguageLoader.load();
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
		this.warpconfig = new WarpConfig();
		this.warpconfig.load();
		this.warpmanager = new WarpManager();
		this.memorieManager = new MemorieManager();
		this.groupconfig = new GroupConfig();
		this.grouploader = new GroupLoader();
		this.groupconfig.load();
		this.grouploader.load();
		this.groupManager = new GroupManager();
		Chat.writeMessage("Version: " + Chat.version);
		Chat.writeMessage("Plugin is started");
	}
	
	@Override
	public void onDisable() 
	{
		this.playerconfig.save();
		this.pluginconfig.save();
		this.commandsloger.save();
		this.warpconfig.save();
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
	
	public CommandLoger getCommandsLoger() 
	{
		return commandsloger;
	}
	
	public WarpConfig getWarpConfig()
	{
		return warpconfig;
	}
	
	public WarpManager getWarpManager() 
	{
		return warpmanager;
	}
	
	public MemorieManager getMemorieManager() 
	{
		return memorieManager;
	}
	
	public GroupConfig getGroupConfig()
	{
		return groupconfig;
	}
	
	public GroupLoader getGroupLoader() 
	{
		return grouploader;
	}
	
	public GroupManager getGroupManager() 
	{
		return groupManager;
	}
	
	public File getLanguageFolder() 
	{
		return languageFolder;
	}
	
	public LanguageLoader getLanguageLoader() 
	{
		return this.LanguageLoader;
	}
	
	public File getJar() 
	{
		return jar;
	}
}
