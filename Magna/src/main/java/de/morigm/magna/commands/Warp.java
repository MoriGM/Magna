package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getWarpManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Warp extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("warp");
		util().registerTranslation("cmd.warp");
		util().registerTranslation("cmd.warp.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "warp"))
			{
				if (args.length >= 1)
				{
					String warpname = args[0];
					if (getWarpManager().containsWarp(warpname))
					{
						if (p.hasPermission(getWarpManager().getWarp(warpname).permission))
						{
							p.teleport(getWarpManager().getWarpLocation(warpname));
							p.sendMessage(Chat.prefix + translate("cmd.warp") + " " + warpname);
						}
					}
					else
						p.sendMessage(Chat.prefix + translate("cmd.warp.error"));
				}
				else
					p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <warp>");
			}
			else
				Chat.noPermission(com);
		}
		else
			Chat.noConsole(com);
		return false;
	}
	
}
