package de.morigm.magna.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class GetWarp extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("getwarp");
		util().registerTranslation("cmd.getwarp.error");
		util().registerTranslation("cmd.getwarp.world");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "getwarp"))
			{
				if (args.length >= 1)
				{
					String warpname = args[0];
					if (Magna.getWarpManager().containsWarp(warpname))
					{
						Location loc = Magna.getWarpManager().getWarpLocation(warpname);
						p.sendMessage(Chat.prefix + "X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " " + translate("cmd.getwarp.world") + ":" + loc.getWorld().getName());
					}
					else
						p.sendMessage(Chat.prefix + translate("cmd.getwarp.error"));
				}
				else
					p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <warp>");
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}
	
}
