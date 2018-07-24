package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Trash extends CommandHelper
{

	public void registerUtils()
	{
		util().registerCommandName(getCommand());
		util().registerPermission("trash");
	}
	
	public boolean onCommand(CommandSender com,Command cmd,String label,String[] args)
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("trash")))
			{
				Inventory inv = Bukkit.createInventory(null, (9 * 6),(ChatColor.RED + "Trash"));
				p.openInventory(inv);
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}
	
}
