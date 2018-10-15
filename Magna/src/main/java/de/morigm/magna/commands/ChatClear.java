package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class ChatClear extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("chatclear");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(testPermission(com, "chatclear"))
			for(int i = 0;i < 100;i++)
				com.sendMessage(" ");
		else
			Chat.noPermission(com);
		return false;
	}

}
