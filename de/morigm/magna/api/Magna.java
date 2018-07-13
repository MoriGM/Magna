package de.morigm.magna.api;

import de.morigm.magna.Main;
import de.morigm.magna.api.manager.CommandSpyManager;
import de.morigm.magna.api.manager.GodModeManager;
import de.morigm.magna.api.manager.GroupManager;
import de.morigm.magna.api.manager.MutedPlayerManager;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.manager.WarpManager;
import de.morigm.magna.api.memorie.MemorieManager;

public class Magna
{
	public static GroupManager getGroupManager()
	{
		return Main.getInstance().getGroupManager();
	}
	
	public static MemorieManager getMemorieManager() 
	{
		return Main.getInstance().getMemorieManager();
	}
	
	public static WarpManager getWarpManager() 
	{
		return Main.getInstance().getWarpManager();
	}
	
	public static MutedPlayerManager getMutedPlayerManager()
	{
		return Main.getInstance().getMutedPlayerManager();
	}
	
	public static GodModeManager getGodModeManager()
	{
		return Main.getInstance().getGodModeManager();
	}
	
	public static CommandSpyManager getCommandSpyManager() 
	{
		return Main.getInstance().getCommandSpyManager();
	}
	
	public static PermissionManager getPermissionManager() 
	{
		return Main.getInstance().getPermissionManager();
	}
}
