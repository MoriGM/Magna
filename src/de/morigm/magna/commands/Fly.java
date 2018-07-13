package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Fly extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player t = (Player) com;
			if(com.hasPermission(getPermission("fly")))
			{
				if(args.length >= 1)
					t = Bukkit.getPlayer(args[0]);
				if(t != null)
				{
					t.setAllowFlight(!t.getAllowFlight());
					com.sendMessage(Chat.prefix + (t.getAllowFlight() ?  (com == t ? translate("cmd.fly.you.on") : translate("cmd.fly.player.on")) : (com == t ? translate("cmd.fly.you.off") : translate("cmd.fly.player.off"))));
				}
				else
					com.sendMessage(Chat.prefix + Chat.no_online);
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
