package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_SetItemName implements CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission("setitemname"))
			{
				if(args.length >= 1)
				{
					if(p.getInventory().getItemInMainHand() != null)
					{
						ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
						meta.setDisplayName(args[0]);
						p.getInventory().getItemInMainHand().setItemMeta(meta);
					}
					else
						p.sendMessage(Chat.prefix + "You have no item in Hand");
				}
				else
					p.sendMessage(Chat.prefix + "/setitemname <name>");
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
