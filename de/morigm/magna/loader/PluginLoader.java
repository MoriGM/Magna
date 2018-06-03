package de.morigm.magna.loader;

import de.morigm.magna.commands.CMD_Fly;
import de.morigm.magna.commands.CMD_GODMODE;
import de.morigm.magna.commands.CMD_IP;
import de.morigm.magna.commands.CMD_ItemHead;
import de.morigm.magna.commands.CMD_MUTED;
import de.morigm.magna.commands.CMD_ReloadConfig;
import de.morigm.magna.commands.CMD_SPY;
import de.morigm.magna.commands.CMD_SetItemName;
import de.morigm.magna.commands.CMD_Warps;
import de.morigm.magna.commands.CMD_getWarp;
import de.morigm.magna.commands.CMD_getpos;
import de.morigm.magna.commands.CMD_getworld;
import de.morigm.magna.commands.CMD_heal;
import de.morigm.magna.commands.CMD_kickall;
import de.morigm.magna.commands.CMD_removeWarp;
import de.morigm.magna.commands.CMD_setWarp;
import de.morigm.magna.commands.CMD_tpall;
import de.morigm.magna.commands.CMD_warp;
import de.morigm.magna.listener.Listener_CMDSPY;
import de.morigm.magna.listener.Listener_ChatColor;
import de.morigm.magna.listener.Listener_ColorSign;
import de.morigm.magna.listener.Listener_CommandLog;
import de.morigm.magna.listener.Listener_GODMODE;
import de.morigm.magna.listener.Listener_Muted;
import de.morigm.magna.listener.Listener_SignWarp;

public class PluginLoader 
{

	public void registerCommands()
	{
		new CMD_Fly().register("fly");
		new CMD_GODMODE().register("godmode");
		new CMD_MUTED().register("mute");
		new CMD_heal().register("heal");
		new CMD_getworld().register("getworld");
		new CMD_SetItemName().register("setitemname");
		new CMD_IP().register("ip");
		new CMD_tpall().register("tpall");
		new CMD_ItemHead().register("itemhead");
		new CMD_SPY().register("cmdspy");
		new CMD_ReloadConfig().register("reloadconfig");
		new CMD_getpos().register("getpos");
		new CMD_setWarp().register("setwarp");
		new CMD_getWarp().register("getwarp");
		new CMD_removeWarp().register("removewarp");
		new CMD_warp().register("warp");
		new CMD_Warps().register("warps");
		new CMD_kickall().register("kickall");
	}
	
	public void registerListener()
	{
		new Listener_GODMODE().register();
		new Listener_Muted().register();
		new Listener_CMDSPY().register();
		new Listener_ChatColor().register();
		new Listener_ColorSign().register();
		new Listener_CommandLog().register();
		new Listener_SignWarp().register();
	}
	
}
