package de.morigm.magna.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_SPY extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("cmdspy")))
			{
				Main.getInstance().getCommandSpyManager().togglePlayer(p);
				p.sendMessage(Chat.prefix + "CommandSPY is now " + (Main.getInstance().getCommandSpyManager().containsPlayer(p) ? (ChatColor.GREEN + "ON") : (ChatColor.RED + "OFF")));
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
