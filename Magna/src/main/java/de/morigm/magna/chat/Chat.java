package de.morigm.magna.chat;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.chat.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Chat {

    public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + Magna.getName()
            + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE;
    public static final String name = Magna.getName();
    public static final String version = Main.getInstance().getDescription().getVersion();
    public static final String no_console = Main.getInstance().getLanguage().translate("chat.no-console");
    public static final String no_player = Main.getInstance().getLanguage().translate("chat.no-player");
    public static final String no_permission = Main.getInstance().getLanguage().translate("chat.no-permission");
    public static final String no_online = Main.getInstance().getLanguage().translate("chat.no-online");
    public static final String no_group = Main.getInstance().getLanguage().translate("chat.no-group");
    public static final String no_int = Main.getInstance().getLanguage().translate("chat.no-int");

    public static void writeMessage(String text) {
        Bukkit.getConsoleSender().sendMessage(Chat.prefix + text);
    }

    public static void writeError(String text) {
        Bukkit.getConsoleSender().sendMessage(Chat.prefix + ChatColor.RED + text);
    }

    public static void noPermission(CommandSender com) {
        com.sendPlainMessage(prefix + no_permission);
    }

    public static void noConsole(CommandSender com) {
        com.sendPlainMessage(prefix + no_console);
    }

    public static void noPlayer(CommandSender com) {
        com.sendPlainMessage(prefix + no_player);
    }

    public static void noOnline(CommandSender com) {
        com.sendPlainMessage(prefix + no_online);
    }

    public static void noInt(CommandSender com) {
        com.sendPlainMessage(prefix + no_int);
    }

}
