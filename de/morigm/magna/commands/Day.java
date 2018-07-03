package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Day extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com.hasPermission("day"))
		{
			if(com instanceof Player)
			{
				Player p = (Player) com;
				p.getWorld().setTime(1600);
				p.sendMessage(Chat.prefix + translate("cmd.day"));
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_console);
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
