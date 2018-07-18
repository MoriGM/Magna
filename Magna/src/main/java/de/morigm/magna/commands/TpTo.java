package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class TpTo extends CommandHelper 
{

	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("tpto");
		util().registerTranslation("cmd.tpto");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("tpto")))
			{
				if(args.length >= 1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null)
					{
						p.teleport(t);
						p.sendMessage(Chat.prefix + translate("cmd.tpto") + " " + t.getName());
					}
					else
						p.sendMessage(Chat.prefix + Chat.no_online);
				}
				else
					p.sendMessage(Chat.prefix + getCommand() + " <Player>");
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
