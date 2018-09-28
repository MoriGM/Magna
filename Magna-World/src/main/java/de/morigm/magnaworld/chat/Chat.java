package de.morigm.magnaworld.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import de.morigm.magnaworld.api.MagnaWorld;

public class Chat 
{
	
	public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + MagnaWorld.getName() + ChatColor.DARK_GRAY +  "] " + ChatColor.WHITE;
	public static final String name = MagnaWorld.getName();
	
	public static void writeMessage(String text)
	{
		Bukkit.getConsoleSender().sendMessage(Chat.prefix + text);
	}
	
	public static void writeError(String text)
	{
		Bukkit.getConsoleSender().sendMessage(Chat.prefix + ChatColor.RED + text);
	}

}
