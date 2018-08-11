package de.morigm.magna;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.manager.AutoEditManager;
import de.morigm.magna.api.manager.BlackListManager;
import de.morigm.magna.api.manager.CommandSpyManager;
import de.morigm.magna.api.manager.DeathBackManager;
import de.morigm.magna.api.manager.GodModeManager;
import de.morigm.magna.api.manager.GroupManager;
import de.morigm.magna.api.manager.MSGManager;
import de.morigm.magna.api.manager.MutedPlayerManager;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.manager.WarpManager;
import de.morigm.magna.api.memory.MemoryManager;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.config.AutoEditConfig;
import de.morigm.magna.config.BlackListConfig;
import de.morigm.magna.config.DeathBackConfig;
import de.morigm.magna.config.GroupConfig;
import de.morigm.magna.config.PlayerConfig;
import de.morigm.magna.config.PluginConfig;
import de.morigm.magna.config.WarpConfig;
import de.morigm.magna.edits.RegisterAutoEdits;
import de.morigm.magna.loader.AutoEditLoader;
import de.morigm.magna.loader.BlackListLoader;
import de.morigm.magna.loader.DeathBackLoader;
import de.morigm.magna.loader.GroupLoader;
import de.morigm.magna.loader.LanguageLoader;
import de.morigm.magna.loader.PluginLoader;
import de.morigm.magna.loader.WarpLoader;
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
	@Getter private MemoryManager memoryManager;
	@Getter private GroupManager groupManager;
	@Getter private DeathBackManager deathBackManager;
	@Getter private AutoEditManager autoEditManager;
	@Getter private BlackListManager blackListManager;
	@Getter private MSGManager MSGManager;
	
	@Getter private RegisterAutoEdits registerAutoEdits;
	
	@Getter private PlayerConfig playerConfig;
	private PluginConfig pluginConfig;
	@Getter private WarpConfig warpConfig;
	@Getter private GroupConfig groupConfig;
	@Getter private DeathBackConfig deathBackConfig;
	@Getter private AutoEditConfig autoEditConfig;
	@Getter private BlackListConfig blackListConfig;
	
	@Getter private CommandLoger commandsLoger;

	@Getter private GroupLoader groupLoader;
	@Getter private WarpLoader warpLoader;
	@Getter private DeathBackLoader deathBackLoader;
	@Getter private AutoEditLoader autoEditLoader;
	@Getter private BlackListLoader blackListLoader;
	
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
		this.warpLoader = new WarpLoader();
		this.warpLoader.load();
		this.warpManager = new WarpManager();
		this.memoryManager = new MemoryManager();
		this.groupConfig = new GroupConfig();
		this.groupLoader = new GroupLoader();
		this.groupConfig.load();
		this.groupLoader.load();
		this.groupManager = new GroupManager();
		this.deathBackConfig = new DeathBackConfig();
		this.deathBackConfig.load();
		this.deathBackLoader = new DeathBackLoader();
		this.deathBackLoader.load();
		this.deathBackManager = new DeathBackManager();
		this.registerAutoEdits = new RegisterAutoEdits();
		this.registerAutoEdits.registerServerStruct();
		this.registerAutoEdits.registerPlayerStruct();
		this.autoEditManager = new AutoEditManager();
		this.autoEditConfig = new AutoEditConfig();
		this.autoEditConfig.load();
		this.autoEditLoader = new AutoEditLoader();
		this.autoEditLoader.loadPlayerEdit();
		this.autoEditLoader.loadServerEdit();
		this.blackListConfig = new BlackListConfig();
		this.blackListConfig.load();
		this.blackListLoader = new BlackListLoader();
		this.blackListLoader.load();
		this.blackListManager = new BlackListManager();
		this.MSGManager = new MSGManager();
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
		this.warpLoader.save();
		this.warpConfig.save();
		this.deathBackLoader.save();
		this.deathBackConfig.save();
		this.blackListLoader.save();
		this.blackListConfig.save();
		Chat.writeMessage(this.getLanguage().translate("plugin.stop"));
	}
	
	public PluginConfig getDefaultPluginConfig() 
	{
		return pluginConfig;
	}
}
