package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getHomeManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.api.home.Home;
import de.morigm.magna.chat.Chat;

public class Homes extends CommandHelper 
{

	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("homes");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (PlayerHelper.isPlayer(com))
		{
			Player p = (Player) com;
			if (testPermission(p, "homes"))
			{
				String homes = "";
				for (Home h : getHomeManager().getPlayerHomes(p))
					homes += homes.isEmpty() ? h.name : "," + h.name;
				p.sendMessage(Chat.prefix + "Homes:" + homes);
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}

	

}
