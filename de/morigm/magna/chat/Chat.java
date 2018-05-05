package de.morigm.magna.chat;

import org.bukkit.Bukkit;

import de.morigm.magna.Main;
import net.md_5.bungee.api.ChatColor;

public class Chat 
{

	public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Magna" + ChatColor.DARK_GRAY +  "] " + ChatColor.WHITE;
	public static final String name = Main.getInstance().getDescription().getName();
	public static final String version = Main.getInstance().getDescription().getVersion();
	public static final String no_console = "You must be a Player";
	public static final String no_player = "You must be the Console";
	public static final String no_permission = "You have no Permission to do that";
	
	
	public static void writeMessage(String text)
	{
		Bukkit.getConsoleSender().sendMessage(prefix + text);
	}
	
	
}
