package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.chat.Chat;
import lombok.SneakyThrows;

public class CMDgetUUID extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("getuuid");
	}

	@SneakyThrows
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (testPermission(com, "getuuid"))
		{
			if (args.length >= 1)
			{
				String name = args[0];
				com.sendMessage(Chat.prefix + "UUID:" + MojangApi.getPlayerUUID(name));
			}
			else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <name>");
		}
		else
			Chat.noPermission(com);
		return false;
	}

	

}
