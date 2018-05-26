package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_ItemHead implements CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("itemhead")))
			{
				if(p.getInventory().getItemInMainHand() != null)
				{
					p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
					p.sendMessage(Chat.prefix + "Item is now in the Head Slot");
				}
				else
					p.sendMessage(Chat.prefix + "You have no Item in Hand");
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
