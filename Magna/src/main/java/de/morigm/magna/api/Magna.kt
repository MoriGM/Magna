package de.morigm.magna.api

import de.morigm.magna.Main
import de.morigm.magna.api.command.CommandUtil
import de.morigm.magna.api.language.Language
import de.morigm.magna.api.manager.*
import de.morigm.magna.api.memory.MemoryManager
import de.morigm.magna.api.settings.Folders
import de.morigm.magna.api.settings.Settings
import de.morigm.magna.api.user.User
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

object Magna {
    val supportedVersions: Array<String> = arrayOf("v1_20_R3")

    val name = "Magna"

    var commandUtil: CommandUtil? = null

    var settings: Settings? = null

    var folders: Folders? = null

    init {
        commandUtil = CommandUtil()
        settings = Settings(main)
        folders = Folders()
    }

    @JvmStatic
    val groupManager: GroupManager
        get() = main?.groupManager!!

    @JvmStatic
    val memoryManager: MemoryManager
        get() = main?.memoryManager!!

    @JvmStatic
    val warpManager: WarpManager
        get() = main?.warpManager!!

    @JvmStatic
    val mutedPlayerManager: MutedPlayerManager
        get() = main?.mutedPlayerManager!!

    @JvmStatic
    val godModeManager: GodModeManager
        get() = main?.godModeManager!!

    @JvmStatic
    val commandSpyManager: CommandSpyManager
        get() = main?.commandSpyManager!!

    @JvmStatic
    val permissionManager: PermissionManager
        get() = main?.permissionManager!!

    @JvmStatic
    val deathBackManager: DeathBackManager
        get() = main?.deathBackManager!!

    val autoEditManager: AutoEditManager
        get() = main?.autoEditManager!!

    @JvmStatic
    val mSGManager: MSGManager
        get() = main?.msgManager!!

    @JvmStatic
    val blackListManager: BlackListManager
        get() = main?.blackListManager!!

    @JvmStatic
    val runnerManager: RunnerManager
        get() = main?.runnerManager!!

    @JvmStatic
    val aFKManager: AFK
        get() = main?.afkManager!!

    @JvmStatic
    val homeManager: HomeManager
        get() = main?.homeManager!!

    @JvmStatic
    val signManager: SignManager
        get() = main?.signManager!!

    @JvmStatic
    val onlyBreakManager: OnlyBreakManager
        get() = main?.onlyBreakManager!!

    @JvmStatic
    fun GetWayPointManager(): WayPointManager {
        return main?.wayPointManager!!
    }

    @JvmStatic
    val language: Language
        get() = main?.language!!

    val serverVersion: String
        get() = Bukkit.getServer().javaClass.getPackage().name.replace(".", ",").split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[3]

    @JvmStatic
    val isSupported: Boolean
        get() = Arrays.binarySearch(supportedVersions, serverVersion) >= 0

    @JvmStatic
    fun getUser(p: Player?): User {
        return getUser(p, permissionManager)
    }

    fun getUser(p: Player?, manager: PermissionManager?): User {
        return User(p, manager)
    }

    val main: Main?
        get() = Main.instance
}
