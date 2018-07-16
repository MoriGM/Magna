package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class TeamChat extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("teamchat");
		util().registerPermission("teamchat-see");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("teamchat")))
		{
			if(args.length >= 1)
			{
				String s = "";
				for(String arg : args)
					s += arg + " ";
				s = s.trim();
				for(Player t : Bukkit.getOnlinePlayers())
					if(t.hasPermission(getPermission("teamchat-see")))
					t.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE +  "TeamChat" + ChatColor.GRAY + "]" + ChatColor.RESET +  "<" + (com instanceof Player ? ((Player) com).getName() : "SERVER") + ">" + s);
			}
			else
				com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <Text>");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
