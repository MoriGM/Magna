package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class ReloadConfig extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("magna-reloadconfig");
		util().registerTranslation("cmd.reloadconfig");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(testPermission(com, "magna-reloadconfig"))
		{
			Main.getInstance().reloadConfig();
			Main.getInstance().getDefaultPluginConfig().load();
			if(Main.getInstance().getDefaultPluginConfig().groups.size() >= 1)
			{
				Main.getInstance().getGroupConfig().load();
				Main.getInstance().getGroupLoader().load();
			}
			com.sendMessage(Chat.prefix + translate("cmd.reloadconfig"));
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
