package de.morigm.magna.api.command

import de.morigm.magna.Main.Companion.instance
import de.morigm.magna.api.Magna
import de.morigm.magna.api.Magna.commandUtil
import de.morigm.magna.api.Magna.permissionManager
import de.morigm.magna.api.language.Language
import de.morigm.magna.api.language.TextStruct
import de.morigm.magna.api.manager.PermissionManager
import de.morigm.magna.api.translation.Translation
import de.morigm.magna.api.utility.Permission
import de.morigm.magna.chat.Chat
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

abstract class PluginCommand : Permission(), CommandExecutor, Translation {
    var command: String = ""
        private set
    private var language: Language? = null
    private var permission: PermissionManager? = null

    fun register(cmd_name: String, javaPlugin: JavaPlugin?) {
        this.register(
            cmd_name, if (instance != null) Magna.language else null,
            if (instance != null) permissionManager else null, javaPlugin
        )
    }

    @JvmOverloads
    fun register(cmd_name: String, language: Language? = if (instance != null) Magna.language else null) {
        this.register(
            cmd_name, language, if (instance != null) permissionManager else null,
            instance
        )
    }

    fun register(cmd_name: String, permission: PermissionManager?) {
        this.register(
            cmd_name, if (instance != null) Magna.language else null, permission,
            instance
        )
    }

    fun register(cmd_name: String, language: Language?, permission: PermissionManager?) {
        this.register(cmd_name, language, permission, instance)
    }

    fun register(cmdName: String, language: Language?, permission: PermissionManager?, javaPlugin: JavaPlugin?) {
        command = cmdName
        if (javaPlugin != null) {
            javaPlugin.getCommand(cmdName)!!.setExecutor(this)
        }
        if (language != null) {
            this.language = language
        }
        if (permission != null) {
            this.permission = permission
        }
        registerUtils()
    }

    fun isPlayer(com: CommandSender?): Boolean {
        return com is Player
    }

    fun util(): CommandUtil? {
        return commandUtil
    }

    override fun translate(text: String, vararg structs: TextStruct): String {
        return language!!.translate(text, *structs)
    }

    override fun getPermission(Permission: String): String {
        return permission!!.getPermission(Permission)
    }

    abstract fun registerUtils()

    fun Slash(sender: CommandSender?): String {
        return (if (sender is Player) "/" else "")
    }

    fun sendMessage(sender: CommandSender, msg: String) {
        sender.sendMessage(Chat.prefix + msg)
    }

    fun sendMessageTranslate(sender: CommandSender, msg: String, vararg structs: TextStruct) {
        sender.sendMessage(Chat.prefix + translate(msg, *structs))
    }
}
