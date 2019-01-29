package de.morigm.magna.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getGroupManager;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class KickAll extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("kickall");
		util().registerTranslation("cmd.kickall");
		util().registerTranslation("cmd.kickall.group");
		util().registerTranslation("cmd.kickall.group.no");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (testPermission(com, "kickall"))
		{
			if (args.length >= 1)
			{
				Group group = getGroupManager().getGroup(args[0]);
				if (group != null)
				{
					List<Player> players = getGroupManager().getPlayersByGroup(group);
					for (Player t : players)
						t.kickPlayer("");
					if (!(com instanceof Player))
						Chat.writeMessage(translate("cmd.kickall.group"));
				}
				else
					com.sendMessage(Chat.prefix + translate("cmd.kickall.group.no"));
			}
			else
			{
				for (Player t : Bukkit.getOnlinePlayers())
					t.kickPlayer("");
				if (!(com instanceof Player))
					Chat.writeMessage(translate("cmd.kickall"));
			}
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
