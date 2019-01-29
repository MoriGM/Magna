package de.morigm.magna.commands;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getGroupManager;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Magna_List extends CommandHelper 
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("magna-list");
		util().registerTranslation("cmd.list.player");
		util().registerTranslation("cmd.list.group.notfound");
		util().registerTranslation("cmd.list.player");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args)
	{
		if (testPermission(com, "magna-list"))
		{
			if (getGroupManager().getGroups().length >= 1)
			{
				if (Bukkit.getOnlinePlayers().size() >= 1)
				{
					if (args.length >= 1)
					{
						Group group = getGroupManager().getGroup(args[0]);
						if (group != null)
						{
							List<Player> players = getGroupManager().getPlayersByGroup(group);
							String groups = "";
							for (Player t : players)
								groups += ChatColor.GREEN + t.getName() + ChatColor.RESET + " ";
							com.sendMessage(Chat.prefix + translate("cmd.list.player") + ":" + groups);
						}
						else
							com.sendMessage(Chat.prefix + translate("cmd.list.group.notfound"));
					}
					else
					{
						Map<Player,Group> map = getGroupManager().getOnlinePlayerWithGroup();
						String group = "";
						for (Entry<Player,Group> entry : map.entrySet())
							group += "(" + entry.getKey().getName() + " : " + (entry.getValue() != null ? entry.getValue().name : translate("cmd.list.group.no")) + "),";
						group = group.substring(0,group.length() - 1);
						com.sendMessage(Chat.prefix + group);
					}
				}
				else
					Chat.noPlayer(com);
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_group);
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
