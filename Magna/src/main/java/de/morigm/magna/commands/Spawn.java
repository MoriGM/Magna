package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Spawn extends CommandHelper
{
	
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("spawn");
		util().registerTranslation("cmd.spawn");
		util().registerTranslation("cmd.spawn.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (p.hasPermission(getPermission("spawn")))
			{
				if (Main.getInstance().getDefaultPluginConfig().spawn != null)
				{
					p.teleport(Main.getInstance().getDefaultPluginConfig().spawn);
					p.sendMessage(Chat.prefix + translate("cmd.spawn"));
				}
				else
					p.sendMessage(Chat.prefix + translate("cmd.spawn.error"));
			}
			else
				Chat.noPermission(com);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
