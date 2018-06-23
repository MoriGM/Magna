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
import de.morigm.magna.commands.CMD_allchatclear;
import de.morigm.magna.commands.CMD_chatclear;
import de.morigm.magna.commands.CMD_getWarp;
import de.morigm.magna.commands.CMD_getpos;
import de.morigm.magna.commands.CMD_getworld;
import de.morigm.magna.commands.CMD_group_exec;
import de.morigm.magna.commands.CMD_groups;
import de.morigm.magna.commands.CMD_heal;
import de.morigm.magna.commands.CMD_kickall;
import de.morigm.magna.commands.CMD_list;
import de.morigm.magna.commands.CMD_magna_id;
import de.morigm.magna.commands.CMD_memorie;
import de.morigm.magna.commands.CMD_removeWarp;
import de.morigm.magna.commands.CMD_setWarp;
import de.morigm.magna.commands.CMD_setspawn;
import de.morigm.magna.commands.CMD_spawn;
import de.morigm.magna.commands.CMD_teamchat;
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
		new CMD_ReloadConfig().register("magna-reloadconfig");
		new CMD_getpos().register("getpos");
		new CMD_setWarp().register("setwarp");
		new CMD_getWarp().register("getwarp");
		new CMD_removeWarp().register("removewarp");
		new CMD_warp().register("warp");
		new CMD_Warps().register("warps");
		new CMD_kickall().register("kickall");
		new CMD_memorie().register("memorie");
		new CMD_chatclear().register("chatclear");
		new CMD_allchatclear().register("allchatclear");
		new CMD_groups().register("magna-groups");
		new CMD_magna_id().register("magna-id");
		new CMD_list().register("magna-list");
		new CMD_group_exec().register("magna-group-exec");
		new CMD_teamchat().register("teamchat");
		new CMD_setspawn().register("setspawn");
		new CMD_spawn().register("spawn");
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
