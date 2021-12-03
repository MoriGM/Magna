package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getGroupManager;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDMagna_Id extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("magna-id");
		Util().registerTranslation("cmd.id.true");
		Util().registerTranslation("cmd.id.false");
		Util().registerTranslation("cmd.id.player");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (testPermission(com, "magna-id"))
		{
			if (getGroupManager().getGroups().length >= 1)
			{
				if (com instanceof Player)
				{
					Player t = (Player) com;
					if (args.length >= 1)
						t = Bukkit.getPlayer(args[0]);
					if (t != null)
					{
						Group group = getGroupManager().getGroupFromPlayer(t);
						if (group != null)
							com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.true") + " " + group.name);
						else
							com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.false"));
					}
					else
						Chat.noOnline(com);
				}
				else
				{
					if (args.length >= 1)
					{
						Player t = Bukkit.getPlayer(args[0]);
						if (t != null)
						{
							Group group = getGroupManager().getGroupFromPlayer(t);
							if (group != null)
								com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.true") + " " + group.name);
							else
								com.sendMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " " + translate("cmd.id.false"));
						}
						else
							Chat.noOnline(com);
					}
					else
						Chat.writeMessage(getCommand() + " " + "<Player>");
				}
			}
			else
				com.sendMessage(Chat.prefix + Chat.no_group);
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
