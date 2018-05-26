package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_getpos implements CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("getpos")))
				p.sendMessage(Chat.prefix + "X:" +  p.getLocation().getBlockX() + " Y:" + p.getLocation().getBlockY() + " Z:" + p.getLocation().getBlockZ());
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			com.sendMessage(Chat.no_console);
		return false;
	}

}
