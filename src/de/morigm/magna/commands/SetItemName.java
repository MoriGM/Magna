package de.morigm.magna.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class SetItemName extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("setitemname")))
			{
				if(args.length >= 1)
				{
					if(p.getInventory().getItemInMainHand() != null && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR))
					{
						ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
						meta.setDisplayName(args[0]);
						p.getInventory().getItemInMainHand().setItemMeta(meta);
					}
					else
						p.sendMessage(Chat.prefix + translate("cmd.setitemname.error"));
				}
				else
					p.sendMessage(Chat.prefix + "/" + getCommand() + " <name>");
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
