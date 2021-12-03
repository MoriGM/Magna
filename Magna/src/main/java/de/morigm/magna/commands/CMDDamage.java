package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDDamage extends CommandHelper
{

	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("damage");
		Util().registerTranslation("cmd.damage");
		Util().registerTranslation("cmd.damage.noint");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (testPermission(com, "damage"))
		{
			if (args.length >= 2)
			{
				try 
				{
					int d = Integer.valueOf(args[1]);
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null)
					{
						t.damage(d);
						com.sendMessage(Chat.prefix + translate("cmd.damage"));
					}
					else
						Chat.noOnline(com);
				}
				catch (Exception e) 
				{
					com.sendMessage(Chat.prefix + translate("cmd.damage.noint"));
				}
			}
			else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player> <Damage>");
		}
		else
			Chat.noPermission(com);
		return false;
	}

	

}
