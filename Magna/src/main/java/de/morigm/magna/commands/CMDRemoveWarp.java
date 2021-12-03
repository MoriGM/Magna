package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getWarpManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDRemoveWarp extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("removewarp");
		Util().registerTranslation("cmd.removewarp");
		Util().registerTranslation("cmd.removewarp.error");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "removewarp"))
			{
				if (args.length >= 1)
				{
					String warpname = args[0];
					if (getWarpManager().containsWarp(warpname))
					{
						getWarpManager().removeWarp(warpname);
						p.sendMessage(Chat.prefix + translate("cmd.removewarp"));
					}
					else
						p.sendMessage(Chat.prefix + translate("cmd.removewarp.error"));
				}
				else
					p.sendMessage(Chat.prefix + "/" + getCommand() + " <warp>");
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}
	
}
