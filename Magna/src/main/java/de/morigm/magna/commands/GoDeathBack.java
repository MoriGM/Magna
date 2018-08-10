package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.deathback.DeathBack;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.manager.DeathBackManager;
import de.morigm.magna.chat.Chat;

public class GoDeathBack extends CommandHelper 
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("deathback");
		util().registerTranslation("cmd.deathback");
		util().registerTranslation("cmd.deathback.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(testPermission(p, "deathback"))
			{
				if(getDeathBackManager().hasDeathBack(p))
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
	
	private DeathBackManager getDeathBackManager()
	{
		return Main.getInstance().getDeathBackManager();
	}

	

}
