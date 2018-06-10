package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_allchatclear extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com.hasPermission(getPermission("allchatclear")))
		{
			for(Player p : Bukkit.getOnlinePlayers())
			{
				for(int i = 0;i < 100;i++)
					p.sendMessage(" ");
				if(Main.getInstance().getDefaultPluginConfig().chatclear)
					p.sendMessage(Chat.prefix + "Your Chat was cleared from " + ((com instanceof Player) ? ((Player)com).getName() : "Sever"));
			}
		}
		else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}
	
}
