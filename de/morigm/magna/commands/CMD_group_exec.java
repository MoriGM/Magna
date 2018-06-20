package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_group_exec extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("magna-group-exec")))
		{
			if(getGroupManager().getGroups().length >= 2)
			{
				if(args.length >= 1)
				{
					Group group = getGroupManager().getGroup(args[0]);
					for(Player t : getGroupManager().getPlayersByGroup(group))
						Bukkit.dispatchCommand(com, (args[1].startsWith("/") ? args[1].substring(1,args[1].length()) : args[1]) + " " + t.getName());
					com.sendMessage(Chat.prefix + "All Commands used");
				}
				else
					com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + "magna-group-exec <Group> <Command>");
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_group);
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}


}
