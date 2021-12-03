package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDSetSpawn extends CommandHelper
{
	
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("setspawn");
		Util().registerTranslation("cmd.setspawn");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(com, "setspawn"))
			{
				Magna.getSettings().setSpawn(p.getLocation());
				p.sendMessage(Chat.prefix + translate("cmd.setspawn"));
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
			
		return false;
	}

}
