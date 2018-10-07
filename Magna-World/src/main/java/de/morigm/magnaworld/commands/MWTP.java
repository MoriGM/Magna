package de.morigm.magnaworld.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.chat.Chat;

public class MWTP extends CommandHelper 
{

	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("mwtp");
		util().registerTranslation("cmd.mwtp");
		util().registerTranslation("cmd.mwtp.error");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(PlayerHelper.isPlayer(sender))
			if(testPermission(sender,"mwtp"))
			{
				Player p = (Player) sender;
				if(args.length >= 1)
				{
					String name = args[0];
					World w = Bukkit.getWorld(name);
					if(w != null)
					{
						p.teleport(w.getSpawnLocation());
						p.sendMessage(Chat.prefix + translate("cmd.mwtp"));
					}
					else
						p.sendMessage(Chat.prefix + translate("cmd.mwtp.error"));
				}
				else
					p.sendMessage(Chat.prefix + translate("/" + getCommand() + " <name>"));
			}
			else
				Chat.noPermission(sender);
		else
			Chat.noConsole(sender);
		return false;
	}


}
