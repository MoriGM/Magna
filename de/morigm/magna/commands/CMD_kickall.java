package de.morigm.magna.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_kickall extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("kickall")))
		{
			if(args.length >= 1)
			{
				Group group = getGroupManager().getGroup(args[0]);
				if(group != null)
				{
					List<Player> players = getGroupManager().getPlayersByGroup(group);
					for(Player t : players)
						t.kickPlayer("");
					if(!(com instanceof Player))
						Chat.writeMessage("All Players Kicked in this Group");
				}
				else
					com.sendMessage(Chat.prefix + "There is not Group with this name");
			}
			else
			{
				for(Player t : Bukkit.getOnlinePlayers())
					t.kickPlayer("");
				if(!(com instanceof Player))
					Chat.writeMessage("All Players Kicked");
			}
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
