package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class SetSpawn extends CommandHelper
{
	
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("setspawn");
		util().registerTranslation("cmd.setspawn");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(testPermission(com, "setspawn"))
			{
				Main.getInstance().getDefaultPluginConfig().spawn = p.getLocation();
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
