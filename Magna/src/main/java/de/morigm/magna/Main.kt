package de.morigm.magna

import de.morigm.magna.api.Magna
import de.morigm.magna.api.Magna.isSupported
import de.morigm.magna.api.language.Language
import de.morigm.magna.api.manager.*
import de.morigm.magna.api.memory.MemoryManager
import de.morigm.magna.chat.Chat
import de.morigm.magna.config.*
import de.morigm.magna.edits.RegisterAutoEdits
import de.morigm.magna.loader.*
import de.morigm.magna.log.CommandLogger
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Main : JavaPlugin() {
    var permissionManager: PermissionManager? = null


    var mutedPlayerManager: MutedPlayerManager? = null


    var godModeManager: GodModeManager? = null


    var commandSpyManager: CommandSpyManager? = null


    var warpManager: WarpManager? = null


    var memoryManager: MemoryManager? = null


    var groupManager: GroupManager? = null


    var deathBackManager: DeathBackManager? = null


    var autoEditManager: AutoEditManager? = null


    var blackListManager: BlackListManager? = null


    var msgManager: MSGManager? = null


    var runnerManager: RunnerManager? = null


    var afkManager: AFK? = null


    var homeManager: HomeManager? = null


    var signManager: SignManager? = null


    var onlyBreakManager: OnlyBreakManager? = null


    var wayPointManager: WayPointManager? = null


    var registerAutoEdits: RegisterAutoEdits? = null


    var playerConfig: PlayerConfig? = null
    var defaultPluginConfig: PluginConfig? = null
        private set


    var warpConfig: WarpConfig? = null


    var waypointConfig: WayPointConfig? = null


    var groupConfig: GroupConfig? = null


    var deathBackConfig: DeathBackConfig? = null


    var autoEditConfig: AutoEditConfig? = null


    var blackListConfig: BlackListConfig? = null


    var homeConfig: HomeConfig? = null


    var commandsLoger: CommandLogger? = null


    var groupLoader: GroupLoader? = null


    var warpLoader: WarpLoader? = null


    var wayPointLoader: WayPointLoader? = null


    var deathBackLoader: DeathBackLoader? = null


    var autoEditLoader: AutoEditLoader? = null


    var blackListLoader: BlackListLoader? = null


    var homeLoader: HomeLoader? = null


    var jar: File? = null


    var LanguageLoader: LanguageLoader? = null


    var language: Language? = null


    var listeners: Listeners? = null

    override fun onEnable() {
        instance = this
        this.defaultPluginConfig = PluginConfig()
        defaultPluginConfig!!.load()
        this.jar = this.file
        this.LanguageLoader = LanguageLoader()
        this.LanguageLoader!!.load()
        this.language = Language(Magna.folders?.languageFile)
        language!!.load()
        this.permissionManager = PermissionManager(this.getResource("Permission.yml"))
        permissionManager!!.load()
        val pluginLoader = PluginLoader()
        pluginLoader.registerCommands()
        this.listeners = Listeners()
        listeners!!.load()
        this.playerConfig = PlayerConfig()
        playerConfig!!.load()
        this.mutedPlayerManager = MutedPlayerManager()
        this.godModeManager = GodModeManager()
        this.commandSpyManager = CommandSpyManager()
        this.commandsLoger = CommandLogger()
        commandsLoger!!.load()
        this.warpConfig = WarpConfig()
        warpConfig!!.load()
        this.waypointConfig = WayPointConfig()
        waypointConfig!!.load()
        this.warpLoader = WarpLoader()
        warpLoader!!.load()
        this.wayPointLoader = WayPointLoader()
        wayPointLoader!!.load()
        this.warpManager = WarpManager()
        this.memoryManager = MemoryManager()
        this.groupConfig = GroupConfig()
        this.groupLoader = GroupLoader()
        groupConfig!!.load()
        groupLoader!!.load()
        this.groupManager = GroupManager()
        this.deathBackConfig = DeathBackConfig()
        deathBackConfig!!.load()
        this.deathBackLoader = DeathBackLoader()
        deathBackLoader!!.load()
        this.deathBackManager = DeathBackManager()
        this.registerAutoEdits = RegisterAutoEdits()
        registerAutoEdits!!.registerServerStruct()
        registerAutoEdits!!.registerPlayerStruct()
        this.autoEditManager = AutoEditManager()
        this.autoEditConfig = AutoEditConfig()
        autoEditConfig!!.load()
        this.autoEditLoader = AutoEditLoader()
        autoEditLoader!!.loadPlayerEdit()
        autoEditLoader!!.loadServerEdit()
        this.blackListConfig = BlackListConfig()
        blackListConfig!!.load()
        this.blackListLoader = BlackListLoader()
        blackListLoader!!.load()
        this.blackListManager = BlackListManager()
        this.msgManager = MSGManager()
        this.runnerManager = RunnerManager()
        pluginLoader.registerRunners()
        pluginLoader.startRunners()
        this.afkManager = AFK()
        this.homeConfig = HomeConfig()
        homeConfig!!.load()
        this.homeLoader = HomeLoader()
        homeLoader!!.load()
        this.homeManager = HomeManager()
        this.signManager = SignManager()
        pluginLoader.registerSignListener()
        this.onlyBreakManager = OnlyBreakManager()
        this.wayPointManager = WayPointManager()
        if (Magna.settings!!.warning == true && !isSupported) {
            Chat.writeError(this.language!!.translate("plugin.warning.supported"))
        }
        Chat.writeMessage("Version: " + Chat.version)
        Chat.writeMessage(this.language!!.translate("plugin.start"))
    }

    override fun onDisable() {
        playerConfig!!.save()
        defaultPluginConfig!!.save()
        commandsLoger!!.save()
        warpLoader!!.save()
        wayPointLoader!!.save()
        warpConfig!!.save()
        deathBackLoader!!.save()
        deathBackConfig!!.save()
        blackListLoader!!.save()
        blackListConfig!!.save()
        homeLoader!!.save()
        homeConfig!!.save()
        waypointConfig!!.save()
        Chat.writeMessage(this.language!!.translate("plugin.stop"))
    }

    companion object {
        var instance: Main? = null
    }

}
