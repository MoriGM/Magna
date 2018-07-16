package de.morigm.magna.api.helper;

import de.morigm.magna.Main;

public interface PermissionHelper 
{

	public default String getPermission(String Permission)
	{
		return Main.getInstance().getPermissionManager().getPermission(Permission);
	}
	
}
