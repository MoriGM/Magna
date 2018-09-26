package de.morigm.magna.loader;

import de.morigm.magna.api.Magna;
import de.morigm.magna.commands.AFK;
import de.morigm.magna.commands.AllChatClear;
import de.morigm.magna.commands.BanIps;
import de.morigm.magna.commands.Bans;
import de.morigm.magna.commands.Broadcast;
import de.morigm.magna.commands.Censor;
import de.morigm.magna.commands.ChatClear;
import de.morigm.magna.commands.CommandSpy;
import de.morigm.magna.commands.Damage;
import de.morigm.magna.commands.Day;
import de.morigm.magna.commands.DeleteHome;
import de.morigm.magna.commands.Fly;
import de.morigm.magna.commands.GameMode;
import de.morigm.magna.commands.GameModeInfo;
import de.morigm.magna.commands.GetPos;
import de.morigm.magna.commands.GetWarp;
import de.morigm.magna.commands.GetWorld;
import de.morigm.magna.commands.GoDeathBack;
import de.morigm.magna.commands.GodMode;
import de.morigm.magna.commands.Group_Exec;
import de.morigm.magna.commands.Groups;
import de.morigm.magna.commands.Heal;
import de.morigm.magna.commands.Home;
import de.morigm.magna.commands.Homes;
import de.morigm.magna.commands.IP;
import de.morigm.magna.commands.IsAFK;
import de.morigm.magna.commands.ItemHead;
import de.morigm.magna.commands.KickAll;
import de.morigm.magna.commands.MSG;
import de.morigm.magna.commands.MSGR;
import de.morigm.magna.commands.Magna_Id;
import de.morigm.magna.commands.Magna_List;
import de.morigm.magna.commands.Memory;
import de.morigm.magna.commands.Mute;
import de.morigm.magna.commands.Night;
import de.morigm.magna.commands.OnlyBreak;
import de.morigm.magna.commands.OpenEnderChest;
import de.morigm.magna.commands.OpenWorkbench;
import de.morigm.magna.commands.Ops;
import de.morigm.magna.commands.Pardon;
import de.morigm.magna.commands.ReloadConfig;
import de.morigm.magna.commands.RemoveWarp;
import de.morigm.magna.commands.Repair;
import de.morigm.magna.commands.SetHome;
import de.morigm.magna.commands.SetItemName;
import de.morigm.magna.commands.SetSpawn;
import de.morigm.magna.commands.SetWarp;
import de.morigm.magna.commands.Skull;
import de.morigm.magna.commands.Spawn;
import de.morigm.magna.commands.TPAll;
import de.morigm.magna.commands.TeamChat;
import de.morigm.magna.commands.TpHere;
import de.morigm.magna.commands.TpTo;
import de.morigm.magna.commands.Trash;
import de.morigm.magna.commands.Version;
import de.morigm.magna.commands.Warp;
import de.morigm.magna.commands.Warps;
import de.morigm.magna.commands.getUUID;
import de.morigm.magna.listener.Listener_AFK;
import de.morigm.magna.listener.Listener_AutoEdit;
import de.morigm.magna.listener.Listener_BlackList;
import de.morigm.magna.listener.Listener_CMDSPY;
import de.morigm.magna.listener.Listener_ChatColor;
import de.morigm.magna.listener.Listener_ColorSign;
import de.morigm.magna.listener.Listener_CommandLog;
import de.morigm.magna.listener.Listener_DeathBack;
import de.morigm.magna.listener.Listener_GODMODE;
import de.morigm.magna.listener.Listener_Gui;
import de.morigm.magna.listener.Listener_Muted;
import de.morigm.magna.listener.Listener_NoFallDamage;
import de.morigm.magna.listener.Listener_OnlyBreak;
import de.morigm.magna.listener.Listener_Sign;
import de.morigm.magna.runner.AfkTestRunner;
import de.morigm.magna.sign.TrashSign;
import de.morigm.magna.sign.WarpSign;

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
		new Memory().register("memory");
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
		new Repair().register("repair");
		new Ops().register("ops");
		new Bans().register("bans");
		new BanIps().register("banips");
		new Skull().register("skull");
		new TpTo().register("tpto");
		new TpHere().register("tphere");
		new getUUID().register("getuuid");
		new Trash().register("trash");
		new OpenEnderChest().register("enderchest");
		new OpenWorkbench().register("workbench");
		new GoDeathBack().register("deathback");
		new Censor().register("censor");
		new GameMode().register("gamemode");
		new Pardon().register("pardon");
		new Damage().register("damage");
		new MSG().register("msg");
		new MSGR().register("msgr");
		new AFK().register("afk");
		new IsAFK().register("isafk");
		new SetHome().register("sethome");
		new Homes().register("homes");
		new DeleteHome().register("deletehome");
		new Home().register("home");
		new OnlyBreak().register("onlybreak");
		new Version().register("magna-version");
	}
	
	public void registerListener()
	{
		new Listener_GODMODE().register();
		new Listener_Muted().register();
		new Listener_CMDSPY().register();
		new Listener_ChatColor().register();
		new Listener_ColorSign().register();
		new Listener_CommandLog().register();
		new Listener_DeathBack().register();
		new Listener_NoFallDamage().register();
		new Listener_AutoEdit().register();
		new Listener_BlackList().register();
		new Listener_AFK().register();
		new Listener_Sign().register();
		new Listener_OnlyBreak().register();
		new Listener_Gui().register();
	}
	
	public void registerRunners()
	{
		new AfkTestRunner().register("AfkTestRunner");
	}
	
	public void registerSignListener()
	{
		new WarpSign().register("Warp");
		new TrashSign().register("Trash");
	}
	
	public void startRunners()
	{
		Magna.getRunnerManager().startRunnerTimmer("AfkTestRunner", 20*10L);
	}
	
}
