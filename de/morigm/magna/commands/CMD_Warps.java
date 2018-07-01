package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMD_Warps extends CommandHelper
{
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("warps")))
			{
				String warps = "";
				for(String s : Main.getInstance().getWarpManager().getWarps())
					if(warps.isEmpty())
						warps += s;
					else
						warps += "," + s;
				p.sendMessage(Chat.prefix + translate("cmd.warps") + ":" + warps);
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}
}
