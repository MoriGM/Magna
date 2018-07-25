package de.morigm.magna.api;

import org.bukkit.Bukkit;

import de.morigm.magna.Main;
import de.morigm.magna.api.command.CommandUtil;
import de.morigm.magna.api.manager.CommandSpyManager;
import de.morigm.magna.api.manager.DeathBackManager;
import de.morigm.magna.api.manager.GodModeManager;
import de.morigm.magna.api.manager.GroupManager;
import de.morigm.magna.api.manager.MutedPlayerManager;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.manager.WarpManager;
import de.morigm.magna.api.memory.MemoryManager;

public class Magna
{
	private static String[] spigot_versions = {"v1_12_R1"};
	private static CommandUtil commandutil;
	
	
	public static GroupManager getGroupManager()
	{
		return Main.getInstance().getGroupManager();
	}
	
	public static MemoryManager getMemoryManager() 
	{
		return Main.getInstance().getMemoryManager();
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
	
	public static DeathBackManager getDeathBackManager()
	{
		return Main.getInstance().getDeathBackManager();
	}
	
	public static String getServerVersion()
	{
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		return version;
	}
	
	public static String[] getSupportedVersions()
	{
		return spigot_versions;
	}
	
	public static boolean isSupported()
	{
		for(String s : spigot_versions)
			if(s.equals(getServerVersion()))
				return true;
		return false;
	}
	
	public static CommandUtil getCommandUtil()
	{
		if(Magna.commandutil == null)
			Magna.commandutil = new CommandUtil();
		return Magna.commandutil;
	}
}
