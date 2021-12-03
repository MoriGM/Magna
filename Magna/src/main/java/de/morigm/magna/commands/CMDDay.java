package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDDay extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("day");
		Util().registerTranslation("cmd.day");
	}

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if (testPermission(com, "day"))
		{
			if (com instanceof Player)
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
