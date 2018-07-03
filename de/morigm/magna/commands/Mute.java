package de.morigm.magna.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Mute extends CommandHelper 
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("mute")))
		{
			if(args.length == 1)
			{
				if(args[0].equalsIgnoreCase("list"))
				{
					String players = "";
					for(String uuid : Main.getInstance().getPlayerConfig().muted)
					{
						OfflinePlayer t = Bukkit.getPlayer(UUID.fromString(uuid));
						players += t.getName() + " ";
					}
					com.sendMessage(Chat.prefix + translate("cmd.mute.list") + ": " + players);
				}
				else
					com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <on,off,status> <player> " + translate("cmd.mute.or") + " " + (com instanceof Player ? "/" : "") + getCommand() + " <list>");
			}
			else
			{
				if(args.length >= 2)
				{
					Player t = Bukkit.getPlayer(args[1]);
					if(t != null)
					{
						if(args[0].equalsIgnoreCase("on"))
						{
							if(!Main.getInstance().getMutedPlayerManager().containsPlayer(t))
							{
								Main.getInstance().getMutedPlayerManager().addPlayer(t);
								com.sendMessage(Chat.prefix + translate("cmd.mute.on"));
							}
							else
								com.sendMessage(Chat.prefix + translate("cmd.mute.on.error"));
						}
						else
						if(args[0].equalsIgnoreCase("off"))
						{
							if(Main.getInstance().getMutedPlayerManager().containsPlayer(t))
							{
								Main.getInstance().getMutedPlayerManager().removePlayer(t);
								com.sendMessage(Chat.prefix + translate("cmd.mute.off"));
							}
							else
								com.sendMessage(Chat.prefix + translate("cmd.mute.off.error"));
						}
						else
						if(args[0].equalsIgnoreCase("status"))
						{
							com.sendMessage(Chat.prefix + translate("cmd.mute.status") + " " + (!Main.getInstance().getMutedPlayerManager().containsPlayer(t) ? (translate("cmd.mute.status.not") + " " + ChatColor.GREEN) : ChatColor.RED.toString()) + "muted");
						}
						else
							com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <on,off,status> <player> " + translate("cmd.mute.or") + " " + (com instanceof Player ? "/" : "") + getCommand() + " <list>");
					}
					else
						com.sendMessage(Chat.prefix + Chat.no_player);
				}
				else
				{
					com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <on,off,status> <player> " + translate("cmd.mute.or") + " " + (com instanceof Player ? "/" : "") + getCommand() +  " <list>");
				}
			}
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
