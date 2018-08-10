package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Day extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("day");
		util().registerTranslation("cmd.day");
	}

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if(testPermission(com, "day"))
		{
			if(com instanceof Player)
			{
				Player p = (Player) com;
				p.getWorld().setTime(1600);
				p.sendMessage(Chat.prefix + translate("cmd.day"));
			}
			else
				Chat.noConsole(com);
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
