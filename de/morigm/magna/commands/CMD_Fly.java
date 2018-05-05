package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_Fly implements CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("fly")))
			{
				p.setAllowFlight(!p.getAllowFlight());
				p.sendMessage(Chat.prefix + (p.getAllowFlight() ? "You can now fly" : "You can not fly anymore"));
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
