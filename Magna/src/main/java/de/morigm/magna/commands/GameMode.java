package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class GameMode extends CommandHelper
{
	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("gamemode");
		util().registerTranslation("cmd.magna.gamemode");
		util().registerTranslation("cmd.magna.gamemode.other");		
		util().registerTranslation("cmd.magna.gamemode.error");	
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(testPermission(p, "gamemode"))
			{
				if(args.length >= 1)
				{
					String gm = args[0].toLowerCase();
					Player t = p;
					if(args.length >= 2)
						t = Bukkit.getPlayer(args[1]);
					if(t != null)
					{
						org.bukkit.GameMode gamemode = null;
						
						if(gm.equalsIgnoreCase("creative") || gm.equalsIgnoreCase("1") || gm.equalsIgnoreCase("c"))
							gamemode = org.bukkit.GameMode.CREATIVE;
						if(gm.equalsIgnoreCase("survival") || gm.equalsIgnoreCase("0") || gm.equalsIgnoreCase("s"))
							gamemode = org.bukkit.GameMode.SURVIVAL;
						if(gm.equalsIgnoreCase("adventure") || gm.equalsIgnoreCase("2") || gm.equalsIgnoreCase("a"))
							gamemode = org.bukkit.GameMode.ADVENTURE;
						if(gm.equalsIgnoreCase("spectator") || gm.equalsIgnoreCase("3") || gm.equalsIgnoreCase("sp"))
							gamemode = org.bukkit.GameMode.SPECTATOR;
						
						if(gamemode != null)
						{
							t.setGameMode(gamemode);
							if(t == p)
								p.sendMessage(Chat.prefix + translate("cmd.magna.gamemode") + " " + Chat.toFirstUpAndRemainderLower(t.getGameMode().toString()));
							else
								t.sendMessage(Chat.prefix + translate("cmd.magna.gamemode.other") + " " + Chat.toFirstUpAndRemainderLower(t.getGameMode().toString()));
						}
						else
							p.sendMessage(Chat.prefix + translate("cmd.magna.gamemode.error"));
					}
					else
						Chat.noOnline(p);
				}
			}
			else
				Chat.noPermission(p);
		}
		else
			Chat.noConsole(com);
		return false;
	}
	
}