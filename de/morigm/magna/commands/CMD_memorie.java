package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.memorie.MemorieManager.MemorieType;
import de.morigm.magna.chat.Chat;

public class CMD_memorie extends CommandHelper
{

	public boolean onCommand(CommandSender com,Command cmd,String label,String[] args)
	{
		if(com.hasPermission(getPermission("memorie")))
		{
			com.sendMessage(Chat.prefix + "Used:" + Main.getInstance().getMemorieManager().getUsedMemorie(MemorieType.MEGABYTE) + "MB");
			com.sendMessage(Chat.prefix + "Free:" + Main.getInstance().getMemorieManager().getFreeMemorie(MemorieType.MEGABYTE) + "MB");
			com.sendMessage(Chat.prefix + "Total:" + Main.getInstance().getMemorieManager().getTotalMemorie(MemorieType.MEGABYTE) + "MB");
		}
		else
			com.sendMessage(Chat.no_permission);
		return false;
	}
	
}
