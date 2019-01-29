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
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "tpto"))
			{
				if (args.length >= 1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null)
					{
						p.teleport(t);
						p.sendMessage(Chat.prefix + translate("cmd.tpto") + " " + t.getName());
					}
					else
						Chat.noOnline(p);
				}
				else
					p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
