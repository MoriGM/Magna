package de.morigm.magna;

import java.io.File;

import de.morigm.magna.api.manager.*;
import de.morigm.magna.config.*;
import de.morigm.magna.loader.*;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.memory.MemoryManager;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.edits.RegisterAutoEdits;
import de.morigm.magna.log.CommandLoger;
import lombok.Getter;

public class Main extends JavaPlugin {

	@Getter
	private static Main instance;

	private PluginLoader pluginLoader;

	@Getter
	private PermissionManager permissionManager;
	@Getter
	private MutedPlayerManager mutedPlayerManager;
	@Getter
	private GodModeManager godModeManager;
	@Getter
	private CommandSpyManager commandSpyManager;
	@Getter
	private WarpManager warpManager;
	@Getter
	private MemoryManager memoryManager;
	@Getter
	private GroupManager groupManager;
	@Getter
	private DeathBackManager deathBackManager;
	@Getter
	private AutoEditManager autoEditManager;
	@Getter
	private BlackListManager blackListManager;
	@Getter
	private MSGManager MSGManager;
	@Getter
	private RunnerManager runnerManager;
	@Getter
	private AFKManager AFKManager;
	@Getter
	private HomeManager homeManager;
	@Getter
	private SignManager signManager;
	@Getter
	private OnlyBreakManager onlyBreakManager;
	@Getter
	private WayPointManager wayPointManager;

	@Getter
	private RegisterAutoEdits registerAutoEdits;

	@Getter
	private PlayerConfig playerConfig;
	private PluginConfig pluginConfig;
	@Getter
	private WarpConfig warpConfig;
	@Getter
	private WayPointConfig waypointConfig;
	@Getter
	private GroupConfig groupConfig;
	@Getter
	private DeathBackConfig deathBackConfig;
	@Getter
	private AutoEditConfig autoEditConfig;
	@Getter
	private BlackListConfig blackListConfig;
	@Getter
	private HomeConfig homeConfig;

	@Getter
	private CommandLoger commandsLoger;

	@Getter
	private GroupLoader groupLoader;
	@Getter
	private WarpLoader warpLoader;
	@Getter
	private WayPointLoader wayPointLoader;
	@Getter
	private DeathBackLoader deathBackLoader;
	@Getter
	private AutoEditLoader autoEditLoader;
	@Getter
	private BlackListLoader blackListLoader;
	@Getter
	private HomeLoader homeLoader;

	@Getter
	private File jar;

	@Getter
	private LanguageLoader LanguageLoader;

	@Getter
	private Language language;

	@Override
	public void onEnable() {
		Main.instance = this;
		this.pluginConfig = new PluginConfig();
		this.pluginConfig.load();
		this.jar = this.getFile();
		this.LanguageLoader = new LanguageLoader();
		this.LanguageLoader.load();
		this.language = new Language(Magna.getFolders().getLanguageFile());
		this.language.load();
		this.permissionManager = new PermissionManager(this.getResource("Permission.yml"));
		this.permissionManager.load();
		this.pluginLoader = new PluginLoader();
		this.pluginLoader.registerCommands();
		this.pluginLoader.registerListener();
		this.playerConfig = new PlayerConfig();
		this.playerConfig.load();
		this.mutedPlayerManager = new MutedPlayerManager();
		this.godModeManager = new GodModeManager();
		this.commandSpyManager = new CommandSpyManager();
		this.commandsLoger = new CommandLoger();
		this.commandsLoger.load();
		this.warpConfig = new WarpConfig();
		this.warpConfig.load();
		this.waypointConfig = new WayPointConfig();
		this.waypointConfig.load();
		this.warpLoader = new WarpLoader();
		this.warpLoader.load();
		this.wayPointLoader = new WayPointLoader();
		this.wayPointLoader.load();
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
		this.runnerManager = new RunnerManager();
		this.pluginLoader.registerRunners();
		this.pluginLoader.startRunners();
		this.AFKManager = new AFKManager();
		this.homeConfig = new HomeConfig();
		this.homeConfig.load();
		this.homeLoader = new HomeLoader();
		this.homeLoader.load();
		this.homeManager = new HomeManager();
		this.signManager = new SignManager();
		this.pluginLoader.registerSignListener();
		this.onlyBreakManager = new OnlyBreakManager();
		this.wayPointManager = new WayPointManager();
		if (Magna.getSettings().getWarning() && !Magna.isSupported()) {
			Chat.writeError(Main.getInstance().getLanguage().translate("plugin.warning.supported"));
		}
		Chat.writeMessage("Version: " + Chat.version);
		Chat.writeMessage(this.getLanguage().translate("plugin.start"));
	}

	@Override
	public void onDisable() {
		this.playerConfig.save();
		this.pluginConfig.save();
		this.commandsLoger.save();
		this.warpLoader.save();
		this.wayPointLoader.save();
		this.warpConfig.save();
		this.deathBackLoader.save();
		this.deathBackConfig.save();
		this.blackListLoader.save();
		this.blackListConfig.save();
		this.homeLoader.save();
		this.homeConfig.save();
		this.waypointConfig.save();
		Chat.writeMessage(this.getLanguage().translate("plugin.stop"));
	}

	public PluginConfig getDefaultPluginConfig() {
		return pluginConfig;
	}
}
