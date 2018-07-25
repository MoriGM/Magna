package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.memory.MemoryManager.MemoryType;
import de.morigm.magna.chat.Chat;

public class Memory extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("memory");
		util().registerTranslation("cmd.memory.used");
		util().registerTranslation("cmd.memory.free");
		util().registerTranslation("cmd.memory.total");
	}

	public boolean onCommand(CommandSender com,Command cmd,String label,String[] args)
	{
		if(testPermission(com, "memory"))
		{
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("GIGABYTE") || args[0].equalsIgnoreCase("GB"))
				{
					com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":" + Main.getInstance().getMemoryManager().getUsedMemory(MemoryType.GIGABYTE) + "GB");
					com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":" + Main.getInstance().getMemoryManager().getFreeMemory(MemoryType.GIGABYTE) + "GB");
					com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":" + Main.getInstance().getMemoryManager().getTotalMemory(MemoryType.GIGABYTE) + "GB");
				}
				else
				if(args[0].equalsIgnoreCase("MEGABYTE") || args[0].equalsIgnoreCase("MB"))
				{
					com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":" + Main.getInstance().getMemoryManager().getUsedMemory(MemoryType.MEGABYTE) + "MB");
					com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":" + Main.getInstance().getMemoryManager().getFreeMemory(MemoryType.MEGABYTE) + "MB");
					com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":" + Main.getInstance().getMemoryManager().getTotalMemory(MemoryType.MEGABYTE) + "MB");
				}
				else
				if(args[0].equalsIgnoreCase("KILOBYTE") || args[0].equalsIgnoreCase("KB"))
				{
					com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":" + Main.getInstance().getMemoryManager().getUsedMemory(MemoryType.KILOBYTE) + "KB");
					com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":" + Main.getInstance().getMemoryManager().getFreeMemory(MemoryType.KILOBYTE) + "KB");
					com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":" + Main.getInstance().getMemoryManager().getTotalMemory(MemoryType.KILOBYTE) + "KB");
				}
				else
					com.sendMessage(Chat.prefix + (com instanceof Player ? "/" : "") + getCommand() + " <GIGABYTE,MEGABYTE,KILOBYTE>");
			}
			else
			{
				com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":" + Main.getInstance().getMemoryManager().getUsedMemory(MemoryType.MEGABYTE) + "MB");
				com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":" + Main.getInstance().getMemoryManager().getFreeMemory(MemoryType.MEGABYTE) + "MB");
				com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":" + Main.getInstance().getMemoryManager().getTotalMemory(MemoryType.MEGABYTE) + "MB");
			}
		}
		else
			com.sendMessage(Chat.no_permission);
		return false;
	}
	
}
