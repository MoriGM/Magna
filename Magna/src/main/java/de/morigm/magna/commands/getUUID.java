package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.chat.Chat;
import lombok.SneakyThrows;

public class getUUID extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("getuuid");
	}

	@SneakyThrows
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("getuuid")))
		{
			if(args.length >= 1)
			{
				String name = args[0];
				com.sendMessage(Chat.prefix + "UUID:" + MojangApi.getPlayerUUID(name));
			}
			else
				com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <name>");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

	

}
