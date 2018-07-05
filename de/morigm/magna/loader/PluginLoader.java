package de.morigm.magna.loader;

import de.morigm.magna.commands.Fly;
import de.morigm.magna.commands.GameModeInfo;
import de.morigm.magna.commands.GodMode;
import de.morigm.magna.commands.IP;
import de.morigm.magna.commands.ItemHead;
import de.morigm.magna.commands.Mute;
import de.morigm.magna.commands.Night;
import de.morigm.magna.commands.ReloadConfig;
import de.morigm.magna.commands.CommandSpy;
import de.morigm.magna.commands.Day;
import de.morigm.magna.commands.SetItemName;
import de.morigm.magna.commands.Warps;
import de.morigm.magna.commands.AllChatClear;
import de.morigm.magna.commands.Broadcast;
import de.morigm.magna.commands.ChatClear;
import de.morigm.magna.commands.GetWarp;
import de.morigm.magna.commands.GetPos;
import de.morigm.magna.commands.GetWorld;
import de.morigm.magna.commands.Group_Exec;
import de.morigm.magna.commands.Groups;
import de.morigm.magna.commands.Heal;
import de.morigm.magna.commands.KickAll;
import de.morigm.magna.commands.Magna_List;
import de.morigm.magna.commands.Magna_Id;
import de.morigm.magna.commands.Memorie;
import de.morigm.magna.commands.RemoveWarp;
import de.morigm.magna.commands.SetWarp;
import de.morigm.magna.commands.SetSpawn;
import de.morigm.magna.commands.Spawn;
import de.morigm.magna.commands.TeamChat;
import de.morigm.magna.commands.TPAll;
import de.morigm.magna.commands.Warp;
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
		new Fly().register("fly");
		new GodMode().register("godmode");
		new Mute().register("mute");
		new Heal().register("heal");
		new GetWorld().register("getworld");
		new SetItemName().register("setitemname");
		new IP().register("ip");
		new TPAll().register("tpall");
		new ItemHead().register("itemhead");
		new CommandSpy().register("cmdspy");
		new ReloadConfig().register("magna-reloadconfig");
		new GetPos().register("getpos");
		new SetWarp().register("setwarp");
		new GetWarp().register("getwarp");
		new RemoveWarp().register("removewarp");
		new Warp().register("warp");
		new Warps().register("warps");
		new KickAll().register("kickall");
		new Memorie().register("memorie");
		new ChatClear().register("chatclear");
		new AllChatClear().register("allchatclear");
		new Groups().register("magna-groups");
		new Magna_Id().register("magna-id");
		new Magna_List().register("magna-list");
		new Group_Exec().register("magna-group-exec");
		new TeamChat().register("teamchat");
		new SetSpawn().register("setspawn");
		new Spawn().register("spawn");
		new Day().register("day");
		new Night().register("night");
		new Broadcast().register("broadcast");
		new GameModeInfo().register("gamemodeinfo");
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
