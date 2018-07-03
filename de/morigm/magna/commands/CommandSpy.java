package de.morigm.magna.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CommandSpy extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("cmdspy")))
			{
				Main.getInstance().getCommandSpyManager().togglePlayer(p);
				p.sendMessage(Chat.prefix + translate("cmd.cmdspy") + " " + (Main.getInstance().getCommandSpyManager().containsPlayer(p) ? (ChatColor.GREEN + translate("cmd.cmdspy.on")) : (ChatColor.RED + translate("cmd.cmdspy.off"))));
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

}
