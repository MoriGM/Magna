package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_setWarp extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("setwarp")))
			{
				if(args.length >= 1)
				{
					String warpname = args[0];
					Main.getInstance().getWarpManager().setWarp(warpname, p.getLocation());
					p.sendMessage(Chat.prefix + translate("cmd.setwarp.warp") + " " + warpname + " " + translate("cmd.setwarp.end"));
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
