package de.morigm.magna.commands;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.manager.GroupManager;
import de.morigm.magna.chat.Chat;

public class CMD_list extends CommandHelper 
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args)
	{
		if(com.hasPermission(getPermission("magna-list")))
		{
			if(Bukkit.getOnlinePlayers().size() >= 1)
			{
				if(args.length >= 1)
				{
					Group group = getGroupManager().getGroup(args[0]);
					if(group != null)
					{
						List<Player> players = getGroupManager().getPlayersByGroup(group);
						String groups = "";
						for(Player t : players)
							groups += ChatColor.GREEN + t.getName() + ChatColor.RESET + " ";
						com.sendMessage(Chat.prefix + "Players:" + groups);
					}
					else
						com.sendMessage(Chat.prefix + "This Group does not exists");
				}
				else
				{
					Map<Player,Group> map = getGroupManager().getOnlinePlayerWithGroup();
					String group = "";
					for(Entry<Player,Group> entry : map.entrySet())
						group += "(" + entry.getKey().getName() + " : " + (entry.getValue().name != null ? entry.getValue().name : "NO GROUP") + "),";
					group = group.substring(0,group.length() - 1);
					com.sendMessage(Chat.prefix + group);
				}
			}
			else
				com.sendMessage(Chat.prefix + "No player Online");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}
	
	public GroupManager getGroupManager()
	{
		return Main.getInstance().getGroupManager();
	}

}
