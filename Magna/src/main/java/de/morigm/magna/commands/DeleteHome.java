package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getHomeManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.chat.Chat;

public class DeleteHome extends CommandHelper
{

	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("deletehome");
		util().registerTranslation("cmd.deletehome");
		util().registerTranslation("cmd.deletehome.exists");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (PlayerHelper.isPlayer(com))
		{
			Player p = (Player) com;
			if (testPermission(p, "deletehome"))
			{
				if(args.length >= 1)
				{
					String name = args[0];
					if (getHomeManager().hasHome(p, name))
					{
						getHomeManager().removeHome(p, name);
						p.sendMessage(Chat.prefix + translate("cmd.deletehome"));
					}
					else
						p.sendMessage(Chat.prefix + translate("cmd.deletehome.exists"));
				}
				else
					p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <home>");
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}


}
