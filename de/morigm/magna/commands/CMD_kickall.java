package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_kickall extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("kickall")))
		{
			for(Player p : Bukkit.getOnlinePlayers())
				p.kickPlayer("");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
