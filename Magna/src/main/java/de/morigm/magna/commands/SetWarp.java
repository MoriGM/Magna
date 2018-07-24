package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class SetWarp extends CommandHelper
{
	
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("setwarp");
		util().registerTranslation("cmd.setwarp.warp");
		util().registerTranslation("cmd.setwarp.end");
	}

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
					if(Main.getInstance().getWarpManager().containsWarp(warpname))
						Main.getInstance().getWarpManager().removeWarp(warpname);
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
