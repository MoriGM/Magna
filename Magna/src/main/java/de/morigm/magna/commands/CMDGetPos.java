package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDGetPos extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("getpos");
		Util().registerTranslation("cmd.getpos.world");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(com, "getpos"))
				if (args.length >= 1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null)
						p.sendMessage(Chat.prefix + "X:" +  t.getLocation().getBlockX() + " Y:" + t.getLocation().getBlockY() + " Z:" + t.getLocation().getBlockZ() + " " + translate("cmd.getpos.world") + ":" + t.getLocation().getWorld().getName());
					else
						p.sendMessage(Chat.prefix + Chat.no_online);
				}
				else
					p.sendMessage(Chat.prefix + "X:" +  p.getLocation().getBlockX() + " Y:" + p.getLocation().getBlockY() + " Z:" + p.getLocation().getBlockZ() + " " + translate("cmd.getpos.world") + ":" + p.getLocation().getWorld().getName());
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
