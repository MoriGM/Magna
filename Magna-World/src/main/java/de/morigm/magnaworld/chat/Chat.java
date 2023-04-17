package de.morigm.magnaworld.chat;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magnaworld.api.MagnaWorld;
import org.bukkit.Bukkit;

public class Chat {

    public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + MagnaWorld.getName()
            + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE;
    public static final String name = MagnaWorld.getName();

    public static void writeMessage(String text) {
        Bukkit.getConsoleSender().sendPlainMessage(Chat.prefix + text);
    }

    public static void writeError(String text) {
        Bukkit.getConsoleSender().sendPlainMessage(Chat.prefix + ChatColor.RED + text);
    }

}
