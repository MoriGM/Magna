package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getGodModeManager;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDGodMode extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("godmode");
		Util().registerTranslation("cmd.godmode");
		Util().registerTranslation("cmd.godmode.on");
		Util().registerTranslation("cmd.godmode.off");
		Util().registerTranslation("cmd.godmode.for");
	}

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "godmode"))
			{
				if (args.length >= 1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null)
					{
						getGodModeManager().togglePlayer(t);
						p.sendMessage(Chat.prefix + translate("cmd.godmode") + " " + (getGodModeManager().containsPlayer(t) ? translate("cmd.godmode.on") : translate("cmd.godmode.off")) + " " + translate("cmd.godmode.for") + " " + t.getName());
					}
					else
						Chat.noOnline(p);
						
				}
				else
				{
					getGodModeManager().togglePlayer(p);
					p.sendMessage(Chat.prefix + translate("cmd.godmode") + " " + (getGodModeManager().containsPlayer(p) ? translate("cmd.godmode.on") : translate("cmd.godmode.off")));
				}
			}
			else
				Chat.noPermission(p);
		}
		else
		{
			if (args.length >= 1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				if (t != null)
				{
					getGodModeManager().togglePlayer(t);
					Chat.writeMessage(translate("cmd.godmode") + " " + (getGodModeManager().containsPlayer(t) ? translate("cmd.godmode.on") : translate("cmd.godmode.off")) + " " + translate("cmd.godmode.for") + " " + t.getName());
				}
				else
					Chat.noOnline(com);
			}
			else
				Chat.writeMessage(getCommand() + " <Player>");
		}
		return false;
	}

}