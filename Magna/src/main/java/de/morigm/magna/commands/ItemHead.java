package de.morigm.magna.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class ItemHead extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("itemhead");
		util().registerTranslation("cmd.itemhead");
		util().registerTranslation("cmd.itemhead.no");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "itemhead"))
			{
				if (p.getInventory().getItemInMainHand() != null && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR))
				{
					p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
					p.sendMessage(Chat.prefix + translate("cmd.itemhead"));
				}
				else
					p.sendMessage(Chat.prefix + translate("cmd.itemhead.no"));
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
