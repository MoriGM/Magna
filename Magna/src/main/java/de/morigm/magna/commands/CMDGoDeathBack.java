package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getDeathBackManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.deathback.DeathBack;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDGoDeathBack extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("deathback");
		Util().registerTranslation("cmd.deathback");
		Util().registerTranslation("cmd.deathback.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "deathback"))
			{
				if (getDeathBackManager().hasDeathBack(p))
				{
					DeathBack db = getDeathBackManager().getDeathBack(p);
					p.teleport(db.location);
					p.sendMessage(Chat.prefix + translate("cmd.deathback"));
				}
				else
					p.sendMessage(Chat.prefix + translate("cmd.deathback.error"));
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}
	

}
