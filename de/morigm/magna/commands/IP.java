package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class IP extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("ip")))
		{
			if(args.length >= 1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null)
					com.sendMessage(Chat.prefix + translate("cmd.ip") + " " + t.getName() + " " + translate("cmd.ip.is") + " " + t.getAddress().getHostString());
				else
					com.sendMessage(Chat.prefix + Chat.no_player);
			}
			else
				com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <Player>");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
