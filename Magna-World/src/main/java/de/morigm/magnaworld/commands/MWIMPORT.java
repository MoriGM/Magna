package de.morigm.magnaworld.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import de.morigm.magnaworld.api.MagnaWorld;
import de.morigm.magnaworld.api.world.WorldStruct;

public class MWIMPORT extends CommandHelper
{
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("mwimport");
		util().registerTranslation("cmd.mwimport");
		util().registerTranslation("cmd.mwimport.error");
		util().registerTranslation("cmd.mwimport.missing");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if (testPermission(sender, "mwimport"))
		{
			if (args.length >= 1)
			{
				if (!MagnaWorld.containsWorld(args[0]))
				{
					if (new File(args[0]).isDirectory())
					{
						WorldStruct ws = new WorldStruct(args[0]);
						MagnaWorld.loadWorld(ws);
						sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwimport"));
					}
					else
						sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwimport.missing"));
				}
				else
					sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwimport.error"));
			}
			else
				sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + Slash(sender) + getCommand() + " <name>");
		}
		else
			Chat.noPermission(sender);
		return false;
	}

	

}
