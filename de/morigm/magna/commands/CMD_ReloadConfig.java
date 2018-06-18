package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_ReloadConfig extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("magna-reloadconfig")))
		{
			Main.getInstance().reloadConfig();
			Main.getInstance().getDefaultPluginConfig().load();
			com.sendMessage(Chat.prefix + "Plugin Config reloaded");
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
