package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getWarpManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Warps extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("warps");
		util().registerTranslation("cmd.warps");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(testPermission(p, "warps"))
			{
				String warps = "";
				for(de.morigm.magna.api.warp.Warp w : getWarpManager().getWarps())
					if(warps.isEmpty())
						warps += w.name;
					else
						warps += "," + w.name;
				p.sendMessage(Chat.prefix + translate("cmd.warps") + ":" + warps);
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}
}
