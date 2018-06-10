package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_chatclear extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("chatclear")))
		{
			for(int i = 0;i < 100;i++)
			{
				com.sendMessage(" ");
			}
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
