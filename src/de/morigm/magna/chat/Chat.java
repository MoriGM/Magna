package de.morigm.magna.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import de.morigm.magna.Main;

public class Chat 
{

	public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Magna" + ChatColor.DARK_GRAY +  "] " + ChatColor.WHITE;
	public static final String name = Main.getInstance().getDescription().getName();
	public static final String version = Main.getInstance().getDescription().getVersion();
	public static final String no_console = Main.getInstance().getLanguage().translate("chat.no-console");
	public static final String no_player = Main.getInstance().getLanguage().translate("chat.no-player");
	public static final String no_permission = Main.getInstance().getLanguage().translate("chat.no-permission");
	public static final String no_online = Main.getInstance().getLanguage().translate("chat.no-online");
	public static final String no_group = Main.getInstance().getLanguage().translate("chat.no-group");
	
	public static void writeMessage(String text)
	{
		Bukkit.getConsoleSender().sendMessage(Chat.prefix + text);
	}
	
}
