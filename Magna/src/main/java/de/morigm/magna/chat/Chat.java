package de.morigm.magna.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;

public class Chat 
{

	public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + Magna.getName() + ChatColor.DARK_GRAY +  "] " + ChatColor.WHITE;
	public static final String name = Magna.getName();
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
	
	public static void noPermission(CommandSender com)
	{
		com.sendMessage(prefix + no_permission);
	}
	
	public static void noConsole(CommandSender com)
	{
		com.sendMessage(prefix + no_console);
	}
	
	public static void noPlayer(CommandSender com)
	{
		com.sendMessage(prefix + no_player);
	}
	
	public static void noOnline(CommandSender com)
	{
		com.sendMessage(prefix + no_online);
	}
	
	public static String toFirstUpAndRemainderLower(String text)
	{
		String up = text.toUpperCase();
		String lower = text.toLowerCase();
		return up.substring(0, 1) + lower.substring(1);
	}
	
}
