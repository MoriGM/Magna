package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_Fly extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player t = (Player) com;
			if(com.hasPermission(getPermission("fly")))
			{
				if(args.length >= 1)
					t = Bukkit.getPlayer(args[0]);
				if(t != null)
				{
					t.setAllowFlight(!t.getAllowFlight());
					com.sendMessage(Chat.prefix + (t.getAllowFlight() ?  (com == t ? "You can now fly" : "Player can now Fly") : (com == t ? "You can not fly anymore" : "Player can now Fly")));
				}
				else
					com.sendMessage(Chat.prefix + Chat.no_player);
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
