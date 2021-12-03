package de.morigm.magna.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getCommandSpyManager;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDCommandSpy extends CommandHelper
{

	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("cmdspy");
		Util().registerTranslation("cmd.cmdspy");
		Util().registerTranslation("cmd.cmdspy.on");
		Util().registerTranslation("cmd.cmdspy.off");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (com instanceof Player)
		{
			Player p = (Player) com;
			if (testPermission(p, "cmdspy"))
			{
				getCommandSpyManager().togglePlayer(p);
				p.sendMessage(Chat.prefix + translate("cmd.cmdspy") + " " + (getCommandSpyManager().containsPlayer(p) ? (ChatColor.GREEN + translate("cmd.cmdspy.on")) : (ChatColor.RED + translate("cmd.cmdspy.off"))));
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}

}
