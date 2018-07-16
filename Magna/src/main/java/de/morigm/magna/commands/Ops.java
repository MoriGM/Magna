package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Ops extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("ops")))
		{
			String ops = "";
			for(OfflinePlayer of : Bukkit.getOperators())
				ops += of.getName() + ",";
			ops = ops.substring(0, ops.length() - 1);
			com.sendMessage("Ops:" + ops);
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
