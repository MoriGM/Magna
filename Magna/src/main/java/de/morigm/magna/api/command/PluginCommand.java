package de.morigm.magna.api.command;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.translation.Translation;
import de.morigm.magna.api.utility.Permission;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PluginCommand extends Permission implements CommandExecutor, Translation {

    private String name = "";
    private Language language;
    private PermissionManager permission;

    public void register(String cmd_name) {
        this.register(cmd_name, Main.Companion.getInstance() != null ? Magna.getLanguage() : null);
    }

    public void register(String cmd_name, JavaPlugin javaPlugin) {
        this.register(cmd_name, Main.Companion.getInstance() != null ? Magna.getLanguage() : null,
                Main.Companion.getInstance() != null ? Magna.getPermissionManager() : null, javaPlugin);
    }

    public void register(String cmd_name, Language language) {
        this.register(cmd_name, language, Main.Companion.getInstance() != null ? Magna.getPermissionManager() : null,
                Main.Companion.getInstance());
    }

    public void register(String cmd_name, PermissionManager permission) {
        this.register(cmd_name, Main.Companion.getInstance() != null ? Magna.getLanguage() : null, permission,
                Main.Companion.getInstance());
    }

    public void register(String cmd_name, Language language, PermissionManager permission) {
        this.register(cmd_name, language, permission, Main.Companion.getInstance());
    }

    public void register(String cmdName, Language language, PermissionManager permission, JavaPlugin javaPlugin) {
        name = cmdName;
        if (javaPlugin != null) {
            javaPlugin.getCommand(cmdName).setExecutor(this);
        }
        if (language != null) {
            this.language = language;
        }
        if (permission != null) {
            this.permission = permission;
        }
        registerUtils();
    }

    public String getCommand() {
        return name;
    }

    public boolean isPlayer(CommandSender com) {
        return com instanceof Player;
    }

    public CommandUtil util() {
        return Magna.INSTANCE.getCommandUtil();
    }

    @Override
    public String translate(String text, TextStruct... structs) {
        return language.translate(text, structs);
    }

    @Override
    public String getPermission(String Permission) {
        return this.permission.getPermission(Permission);
    }

    public abstract void registerUtils();

    public String Slash(CommandSender sender) {
        return (sender instanceof Player ? "/" : "");
    }

    public void sendMessage(CommandSender sender, String msg) {
        sender.sendMessage(Chat.prefix + msg);
    }

    public void sendMessageTranslate(CommandSender sender, String msg, TextStruct... structs) {
        sender.sendMessage(Chat.prefix + translate(msg, structs));
    }
}
