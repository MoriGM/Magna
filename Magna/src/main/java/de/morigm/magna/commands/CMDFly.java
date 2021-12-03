package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDFly extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("fly");
		Util().registerTranslation("cmd.fly.you.on");
		Util().registerTranslation("cmd.fly.player.on");
		Util().registerTranslation("cmd.fly.you.off");
		Util().registerTranslation("cmd.fly.player.off");
	}

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player t = (Player) com;
			if (testPermission(t, "fly"))
			{
				if (args.length >= 1)
					t = Bukkit.getPlayer(args[0]);
				if (t != null)
				{
					t.setAllowFlight(!t.getAllowFlight());
					com.sendMessage(Chat.prefix + (t.getAllowFlight() ? ChatColor.GREEN + (com == t ? translate("cmd.fly.you.on") : translate("cmd.fly.player.on")) : ChatColor.RED + (com == t ? translate("cmd.fly.you.off") : translate("cmd.fly.player.off"))));
				}
				else
					Chat.noOnline(com);
			}
			else
				Chat.noPermission(com);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
