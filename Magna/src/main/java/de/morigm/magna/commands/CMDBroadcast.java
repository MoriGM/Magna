package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;

public class CMDBroadcast extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("broadcast");
	}

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if (testPermission(com, "broadcast"))
		{
			if (args.length >= 1)
			{
				String s = StringHelper.StringArrayToString(args, " ").replace('&', ChatColor.COLOR_CHAR);
				Bukkit.broadcastMessage(s);
			}
			else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <message>");
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
