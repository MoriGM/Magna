package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_heal extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player t = (Player) com;
			if(com.hasPermission(getPermission("heal")))
			{
				if(args.length >= 1)
					t = Bukkit.getPlayer(args[0]); 
				if(t != null)
				{
					t.setHealth(t.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
					t.setFoodLevel(20);
					com.sendMessage(Chat.prefix + (t == ((Player) com) ? "You are healed" : "Player was healed"));
				}
				else
					com.sendMessage(Chat.prefix + Chat.no_online);
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
