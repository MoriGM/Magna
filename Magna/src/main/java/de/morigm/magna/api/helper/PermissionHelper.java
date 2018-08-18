package de.morigm.magna.api.helper;

import static de.morigm.magna.api.Magna.getPermissionManager;

import org.bukkit.command.CommandSender;;

public interface PermissionHelper 
{

	public default String getPermission(String Permission)
	{
		return getPermissionManager().getPermission(Permission);
	}
	
	public default boolean testPermission(CommandSender p,String permission)
	{
		return p.hasPermission(getPermission(permission));
	}
	
}
