package de.morigm.magna.api.helper;

import org.bukkit.command.CommandSender;

import de.morigm.magna.Main;

public interface PermissionHelper 
{

	public default String getPermission(String Permission)
	{
		return Main.getInstance().getPermissionManager().getPermission(Permission);
	}
	
	public default boolean testPermission(CommandSender p,String permission)
	{
		return p.hasPermission(getPermission(permission));
	}
	
}
