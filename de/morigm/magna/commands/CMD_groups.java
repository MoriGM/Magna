package de.morigm.magna.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.Main;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_groups extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("magna-groups")))
		{
			String groups = "";
			for(Group group : Main.getInstance().getGroupManager().getGroups())
				groups += ChatColor.GREEN + group.name + ChatColor.RESET + " ";
			groups = groups.substring(0,groups.length() - 1);
			com.sendMessage(Chat.prefix + "Groups:" + groups);
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
