package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDTPAll extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("tpall");
		Util().registerTranslation("cmd.tpall");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "tpall"))
			{
				for (Player t : Bukkit.getOnlinePlayers())
					if (t != p)
						t.teleport(p);
				p.sendMessage(Chat.prefix + translate("cmd.tpall"));
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}


}
