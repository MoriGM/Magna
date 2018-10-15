package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.convert.Convert;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.chat.Chat;

public class FlySpeed extends CommandHelper 
{

	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("flyspeed");
		util().registerTranslation("cmd.flyspeed.you");
		util().registerTranslation("cmd.flyspeed.player");
		util().registerTranslation("cmd.flyspeed.error");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(PlayerHelper.isPlayer(sender))
		{
			Player p = (Player) sender;
			if(testPermission(p, "flyspeed"))
				if(args.length >= 1)
				{
					if(Convert.isInteger(args[0]))
					{
						float f = Float.valueOf(args[0]) / 10;
						
						if(Integer.valueOf(args[0]) > 10 || Integer.valueOf(args[0]) < 0)
						{
							p.sendMessage(Chat.prefix + translate("cmd.flyspeed.error"));
							return false;
						}
						
						Player t = args.length >= 2 ? Bukkit.getPlayer(args[1]) : p;
						if(t != null)
						{
							t.setFlySpeed(f);
							p.sendMessage(Chat.prefix + (t == p ? translate("cmd.flyspeed.you") : translate("cmd.flyspeed.player") + " " + args[1]));
						}
						else
							Chat.noOnline(p);
					}
					else
						Chat.noInt(p);
				}
				else
					p.sendMessage(Chat.prefix + Slash(sender) +  getCommand() + " <speed> [Player]");
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(sender);
		return false;
	}

}
