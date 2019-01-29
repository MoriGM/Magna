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
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "trash"))
			{
				Inventory inv = Bukkit.createInventory(null, (9 * 6),(ChatColor.RED + "Trash"));
				p.openInventory(inv);
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}
	
}
