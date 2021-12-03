package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.gui.DebugGui;

public class CMDVersion extends CommandHelper
{

	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("version");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if (PlayerHelper.isPlayer(sender) && !testPermission(sender, "version"))
		{
			Chat.noPermission(sender);
			return false;
		}
		if (args.length >= 1 && PlayerHelper.isPlayer(sender))
			if (args[0].equalsIgnoreCase("debug") && Magna.getSettings().getDebug())
			{
				DebugGui gui = new DebugGui();
				Magna.getUser(PlayerHelper.toPlayer(sender)).openGui(gui);
			}		
				
		sender.sendMessage(Chat.prefix + "Version:" + Chat.version);
		
		return false;
	}

	

}
