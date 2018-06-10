package de.morigm.magna.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_getWarp extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("getwarp")))
			{
				if(args.length >= 1)
				{
					String warpname = args[0];
					if(Main.getInstance().getWarpManager().containsWarp(warpname))
					{
						Location loc = Main.getInstance().getWarpManager().getWarp(warpname);
						p.sendMessage(Chat.prefix + "X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " World:" + loc.getWorld().getName());
					}
					else
						p.sendMessage(Chat.prefix + "Warp doesn't exists");
				}
				else
					p.sendMessage(Chat.prefix + "/" + getCommand() + " <warp>");
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}
	
}