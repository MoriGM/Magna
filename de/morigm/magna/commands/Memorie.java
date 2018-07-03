package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.memorie.MemorieManager.MemorieType;
import de.morigm.magna.chat.Chat;

public class Memorie extends CommandHelper
{

	public boolean onCommand(CommandSender com,Command cmd,String label,String[] args)
	{
		if(com.hasPermission(getPermission("memorie")))
		{
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("GIGABYTE") || args[0].equalsIgnoreCase("GB"))
				{
					com.sendMessage(Chat.prefix + translate("cmd.memorie.used") + ":" + Main.getInstance().getMemorieManager().getUsedMemorie(MemorieType.GIGABYTE) + "GB");
					com.sendMessage(Chat.prefix + translate("cmd.memorie.used") + ":" + Main.getInstance().getMemorieManager().getFreeMemorie(MemorieType.GIGABYTE) + "GB");
					com.sendMessage(Chat.prefix + translate("cmd.memorie.used") + ":" + Main.getInstance().getMemorieManager().getTotalMemorie(MemorieType.GIGABYTE) + "GB");
				}
				else
				if(args[0].equalsIgnoreCase("MEGABYTE") || args[0].equalsIgnoreCase("MB"))
				{
					com.sendMessage(Chat.prefix + translate("cmd.memorie.used") + ":" + Main.getInstance().getMemorieManager().getUsedMemorie(MemorieType.MEGABYTE) + "MB");
					com.sendMessage(Chat.prefix + translate("cmd.memorie.free") + ":" + Main.getInstance().getMemorieManager().getFreeMemorie(MemorieType.MEGABYTE) + "MB");
					com.sendMessage(Chat.prefix + translate("cmd.memorie.total") + ":" + Main.getInstance().getMemorieManager().getTotalMemorie(MemorieType.MEGABYTE) + "MB");
				}
				else
				if(args[0].equalsIgnoreCase("KILOBYTE") || args[0].equalsIgnoreCase("KB"))
				{
					com.sendMessage(Chat.prefix + translate("cmd.memorie.used") + ":" + Main.getInstance().getMemorieManager().getUsedMemorie(MemorieType.KILOBYTE) + "KB");
					com.sendMessage(Chat.prefix + translate("cmd.memorie.free") + ":" + Main.getInstance().getMemorieManager().getFreeMemorie(MemorieType.KILOBYTE) + "KB");
					com.sendMessage(Chat.prefix + translate("cmd.memorie.total") + ":" + Main.getInstance().getMemorieManager().getTotalMemorie(MemorieType.KILOBYTE) + "KB");
				}
				else
					com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + "memorie <GIGABYTE,MEGABYTE,KILOBYTE>");
			}
			else
			{
				com.sendMessage(Chat.prefix + translate("cmd.memorie.used") + ":" + Main.getInstance().getMemorieManager().getUsedMemorie(MemorieType.MEGABYTE) + "MB");
				com.sendMessage(Chat.prefix + translate("cmd.memorie.free") + ":" + Main.getInstance().getMemorieManager().getFreeMemorie(MemorieType.MEGABYTE) + "MB");
				com.sendMessage(Chat.prefix + translate("cmd.memorie.total") + ":" + Main.getInstance().getMemorieManager().getTotalMemorie(MemorieType.MEGABYTE) + "MB");
			}
		}
		else
			com.sendMessage(Chat.no_permission);
		return false;
	}
	
}
