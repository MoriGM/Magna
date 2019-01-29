package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class IsAFK extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("isafk");
		util().registerTranslation("cmd.isafk.on");
		util().registerTranslation("cmd.isafk.off");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (testPermission(com, "isafk"))
		{
			if (args.length >= 1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				if (t != null)
				{	
					if (Magna.getAFKManager().isAfk(t))
						com.sendMessage(Chat.prefix + translate("cmd.isafk.on"));
					else
						com.sendMessage(Chat.prefix + translate("cmd.isafk.off"));
				}
				else
					Chat.noOnline(com);
			}
			else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
		}
		else
			Chat.noPermission(com);
		return false;
	}

	

}
