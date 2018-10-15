package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getBlackListManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.censor.CensorType;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class Censor extends CommandHelper
{
	
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("censor");
		util().registerPermission("blacklistword");
		util().registerTranslation("cmd.censor.add");
		util().registerTranslation("cmd.censor.add.error");
		util().registerTranslation("cmd.censor.remove");
		util().registerTranslation("cmd.censor.remove.error");
		util().registerTranslation("cmd.censor.words");
		util().registerTranslation("cmd.censor.or");
		util().registerTranslation("cmd.censor.type");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args)
	{
		if(testPermission(com, "censor"))
		{
			if(args.length >= 2)
			{
				String word = args[1];
				
					
				if(args[0].equalsIgnoreCase("add"))
				{
					if(!getBlackListManager().containsBlackWord(word))
					{
						String permission = getPermission("blacklistword");
						CensorType type = CensorType.NORMAL;
						if(args.length >= 3)
							permission = args[2];
						if(args.length >= 4)
							type = CensorType.getType(args[3]);
						BlackWord bword = new BlackWord(word, permission, type);
						getBlackListManager().addBlackWord(bword);
						com.sendMessage(Chat.prefix + translate("cmd.censor.add"));
					}
					else
						com.sendMessage(Chat.prefix + translate("cmd.censor.add.error"));
				}
				else
				if(args[0].equalsIgnoreCase("remove"))
				{
					if(getBlackListManager().containsBlackWord(word))
					{
						getBlackListManager().removeBlackWord(getBlackListManager().getBlackWord(word));
						com.sendMessage(Chat.prefix + translate("cmd.censor.remove"));
					}
					else
						com.sendMessage(Chat.prefix + translate("cmd.censor.remove.error"));
				}
				else
					com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <add,remove> <word> [permission] [type] " + translate("cmd.censor.or") + Slash(com) + getCommand() + " <list,types>");
			}
			else
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("list"))
				{
					String words = "";
					for(BlackWord bword : getBlackListManager().getBlackWords())
							words += bword.word + ",";
					if(!words.isEmpty())
							words = words.substring(0,words.length() - 1);
					com.sendMessage(Chat.prefix + translate("cmd.censor.words") + ":" + words);
				}
				else
				if(args[0].equalsIgnoreCase("types"))
					com.sendMessage(Chat.prefix + translate("cmd.censor.type") + ":" + getTypes());
				else
					com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <add,remove> <word> [permission] [type] " + translate("cmd.censor.or") + Slash(com) + getCommand() + " <list,types>");
			}
			else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <add,remove> <word> [permission] [type] " + translate("cmd.censor.or") + Slash(com) + getCommand() + " <list,types>");
		}
		else
			Chat.noPermission(com);
		return false;
	}
	
	public String getTypes()
	{
		String types = "";
		for(CensorType type : CensorType.values())
			types += type.name() + ",";
		if(!types.isEmpty())
			types.substring(0, types.length() - 1);
		return types;
	}

}
