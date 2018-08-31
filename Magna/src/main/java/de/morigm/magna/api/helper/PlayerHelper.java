package de.morigm.magna.api.helper;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerHelper 
{
	
	public static boolean isPlayer(CommandSender sender)
	{
		return sender instanceof Player;
	}
	
	public static Player toPlayer(CommandSender sender)
	{
		return (Player) sender;
	}

}
