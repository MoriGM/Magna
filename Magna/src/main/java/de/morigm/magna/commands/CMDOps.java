package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDOps extends CommandHelper
{

	@Override
	public void registerUtils() 
	{
		Util().registerCommandName(getCommand());
		Util().registerPermission("ops");
	}
	
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if (testPermission(com, "ops"))
		{
			String ops = "";
			for (OfflinePlayer of : Bukkit.getOperators())
				ops += of.getName() + ",";
			ops = ops.substring(0, ops.length() - 1);
			com.sendMessage("Ops:" + ops);
		}
		else
			Chat.noPermission(com);
		return false;
	}

}
