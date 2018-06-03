package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_GODMODE extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("godmode")))
			{
				if(args.length >= 1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null)
					{
						Main.getInstance().getGodModeManager().togglePlayer(t);
						p.sendMessage(Chat.prefix + "Godmode is now " + (Main.getInstance().getGodModeManager().containsPlayer(t) ? "On" : "Off") + " for Player " + t.getName());
					}
					else
						p.sendMessage(Chat.prefix + Chat.no_online);
						
				}
				else
				{
					Main.getInstance().getGodModeManager().togglePlayer(p);
					p.sendMessage(Chat.prefix + "Godmode is now " + (Main.getInstance().getGodModeManager().containsPlayer(p) ? "On" : "Off"));
				}
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
		{
			if(args.length >= 1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null)
				{
					Main.getInstance().getGodModeManager().togglePlayer(t);
					Chat.writeMessage("Godmode is now " + (Main.getInstance().getGodModeManager().containsPlayer(t) ? "On" : "Off") + " for Player " + t.getName());
				}
				else
					Chat.writeMessage(Chat.no_online);
			}
			else
				Chat.writeMessage(getCommand() + " <Player>");
		}
		return false;
	}

}
