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
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("setitemname");
		util().registerTranslation("cmd.setitemname.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "setitemname"))
			{
				if (args.length >= 1)
				{
					if (p.getInventory().getItemInMainHand() != null && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR))
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
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
