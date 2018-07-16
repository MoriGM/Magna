package de.morigm.magna;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.Language;
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
import lombok.Getter;

public class Main extends JavaPlugin
{

	@Getter private static Main instance;
	
	private PluginLoader pluginLoader;
	
	@Getter private PermissionManager permissionManager;
	@Getter private MutedPlayerManager mutedPlayerManager;
	@Getter private GodModeManager godModeManager;
	@Getter private CommandSpyManager commandSpyManager;
	@Getter private WarpManager warpManager;
	@Getter private MemorieManager memorieManager;
	@Getter private GroupManager groupManager;
	
	@Getter private PlayerConfig playerConfig;
	private PluginConfig pluginConfig;
	@Getter private WarpConfig warpConfig;
	@Getter private GroupConfig groupConfig;
	
	@Getter private CommandLoger commandsLoger;

	@Getter private GroupLoader groupLoader;
	
	@Getter private File languageFolder;
	@Getter private File jar;
			
	@Getter private LanguageLoader LanguageLoader;

	@Getter private Language language;
	

	@Override
	public void onEnable() 
	{
		Main.instance = this;
		this.languageFolder = new File(getDataFolder(),"languages");
		this.pluginConfig = new PluginConfig();
		this.pluginConfig.load();
		this.jar = this.getFile();
		this.LanguageLoader = new LanguageLoader();
		this.LanguageLoader.load();
		this.language = new Language();
		this.language.load();
		this.permissionManager = new PermissionManager();
		this.permissionManager.load();
		this.pluginLoader = new PluginLoader();
		this.pluginLoader.registerCommands();
		this.pluginLoader.registerListener();
		this.playerConfig = new PlayerConfig();
		this.playerConfig.load();
		this.mutedPlayerManager = new MutedPlayerManager();
		this.godModeManager = new  GodModeManager();
		this.commandSpyManager = new CommandSpyManager();
		this.commandsLoger = new CommandLoger();
		this.commandsLoger.load();
		this.warpConfig = new WarpConfig();
		this.warpConfig.load();
		this.warpManager = new WarpManager();
		this.memorieManager = new MemorieManager();
		this.groupConfig = new GroupConfig();
		this.groupLoader = new GroupLoader();
		this.groupConfig.load();
		this.groupLoader.load();
		this.groupManager = new GroupManager();
		if(Main.getInstance().getDefaultPluginConfig().warning && !Magna.isSupported())
			Chat.writeMessage(Main.getInstance().getLanguage().translate("plugin.warning.supported"));
		Chat.writeMessage("Version: " + Chat.version);
		Chat.writeMessage(this.getLanguage().translate("plugin.start"));
	}
	
	@Override
	public void onDisable() 
	{
		this.playerConfig.save();
		this.pluginConfig.save();
		this.commandsLoger.save();
		this.warpConfig.save();
		Chat.writeMessage(this.getLanguage().translate("plugin.stop"));
	}
	
//	public static Main getInstance() 
//	{
//		return instance;
//	}
//	
//	public PermissionManager getPermissionManager() 
//	{
//		return permissionManager;
//	}
//	
//	public PlayerConfig getPlayerConfig()
//	{
//		return playerconfig;
//	}
//	
//	public MutedPlayerManager getMutedPlayerManager()
//	{
//		return mutedPlayerManager;
//	}
//	
//	public GodModeManager getGodModeManager()
//	{
//		return godModeManager;
//	}
//	
//	public CommandSpyManager getCommandSpyManager() 
//	{
//		return commandSpyManager;
//	}
//	
	public PluginConfig getDefaultPluginConfig() 
	{
		return pluginConfig;
	}
	
//	public CommandLoger getCommandsLoger() 
//	{
//		return commandsloger;
//	}
//	
//	public WarpConfig getWarpConfig()
//	{
//		return warpconfig;
//	}
//	
//	public WarpManager getWarpManager() 
//	{
//		return warpmanager;
//	}
//	
//	public MemorieManager getMemorieManager() 
//	{
//		return memorieManager;
//	}
//	
//	public GroupConfig getGroupConfig()
//	{
//		return groupconfig;
//	}
//	
//	public GroupLoader getGroupLoader() 
//	{
//		return grouploader;
//	}
//	
//	public GroupManager getGroupManager() 
//	{
//		return groupManager;
//	}
//	
//	public File getLanguageFolder() 
//	{
//		return languageFolder;
//	}
//	
//	public LanguageLoader getLanguageLoader() 
//	{
//		return this.LanguageLoader;
//	}
//	
//	public File getJar() 
//	{
//		return jar;
//	}
//	
//	public Language getLanguage() 
//	{
//		return language;
//	}
}
