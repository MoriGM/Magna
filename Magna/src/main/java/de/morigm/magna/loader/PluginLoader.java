package de.morigm.magna.loader;

import de.morigm.magna.api.Magna;
import de.morigm.magna.commands.CMDAFK;
import de.morigm.magna.commands.CMDAllChatClear;
import de.morigm.magna.commands.CMDBanIps;
import de.morigm.magna.commands.CMDBans;
import de.morigm.magna.commands.CMDBroadcast;
import de.morigm.magna.commands.CMDCensor;
import de.morigm.magna.commands.CMDChatClear;
import de.morigm.magna.commands.CMDCommandSpy;
import de.morigm.magna.commands.CMDDamage;
import de.morigm.magna.commands.CMDDay;
import de.morigm.magna.commands.CMDDeleteHome;
import de.morigm.magna.commands.CMDFly;
import de.morigm.magna.commands.CMDFlySpeed;
import de.morigm.magna.commands.CMDGameMode;
import de.morigm.magna.commands.CMDGameModeInfo;
import de.morigm.magna.commands.CMDGetPos;
import de.morigm.magna.commands.CMDGetWarp;
import de.morigm.magna.commands.CMDGetWorld;
import de.morigm.magna.commands.CMDGoDeathBack;
import de.morigm.magna.commands.CMDGodMode;
import de.morigm.magna.commands.CMDGroup_Exec;
import de.morigm.magna.commands.CMDGroups;
import de.morigm.magna.commands.CMDHeal;
import de.morigm.magna.commands.CMDHome;
import de.morigm.magna.commands.CMDHomes;
import de.morigm.magna.commands.CMDIP;
import de.morigm.magna.commands.CMDIsAFK;
import de.morigm.magna.commands.CMDItemHead;
import de.morigm.magna.commands.CMDKickAll;
import de.morigm.magna.commands.CMDMSG;
import de.morigm.magna.commands.CMDMSGR;
import de.morigm.magna.commands.CMDMagna_Id;
import de.morigm.magna.commands.CMDMagna_List;
import de.morigm.magna.commands.CMDMemory;
import de.morigm.magna.commands.CMDMute;
import de.morigm.magna.commands.CMDNight;
import de.morigm.magna.commands.CMDOnlyBreak;
import de.morigm.magna.commands.CMDOpenEnderChest;
import de.morigm.magna.commands.CMDOpenWorkbench;
import de.morigm.magna.commands.CMDOps;
import de.morigm.magna.commands.CMDPardon;
import de.morigm.magna.commands.CMDReloadConfig;
import de.morigm.magna.commands.CMDRemoveWarp;
import de.morigm.magna.commands.CMDRepair;
import de.morigm.magna.commands.CMDSetHome;
import de.morigm.magna.commands.CMDSetItemName;
import de.morigm.magna.commands.CMDSetSpawn;
import de.morigm.magna.commands.CMDSetWarp;
import de.morigm.magna.commands.CMDSkull;
import de.morigm.magna.commands.CMDSpawn;
import de.morigm.magna.commands.CMDSpeed;
import de.morigm.magna.commands.CMDTPAll;
import de.morigm.magna.commands.CMDTeamChat;
import de.morigm.magna.commands.CMDTpHere;
import de.morigm.magna.commands.CMDTpTo;
import de.morigm.magna.commands.CMDTrash;
import de.morigm.magna.commands.CMDVersion;
import de.morigm.magna.commands.CMDWarp;
import de.morigm.magna.commands.CMDWarps;
import de.morigm.magna.commands.CMDWayPoint;
import de.morigm.magna.commands.CMDgetUUID;
import de.morigm.magna.listener.AFK;
import de.morigm.magna.listener.AutoEdit;
import de.morigm.magna.listener.BlackList;
import de.morigm.magna.listener.CommandSpying;
import de.morigm.magna.listener.ChatColor;
import de.morigm.magna.listener.ColorSign;
import de.morigm.magna.listener.LogCommands;
import de.morigm.magna.listener.DeathBack;
import de.morigm.magna.listener.GodMode;
import de.morigm.magna.listener.GuiController;
import de.morigm.magna.listener.MutePlayer;
import de.morigm.magna.listener.NoFallDamage;
import de.morigm.magna.listener.OnlyBreak;
import de.morigm.magna.listener.SignManipulator;
import de.morigm.magna.runner.AfkTestRunner;
import de.morigm.magna.sign.TrashSign;
import de.morigm.magna.sign.WarpSign;

public class PluginLoader {

	public void registerCommands() {
		new CMDFly().register("fly");
		new CMDGodMode().register("godmode");
		new CMDMute().register("mute");
		new CMDHeal().register("heal");
		new CMDGetWorld().register("getworld");
		new CMDSetItemName().register("setitemname");
		new CMDIP().register("ip");
		new CMDTPAll().register("tpall");
		new CMDItemHead().register("itemhead");
		new CMDCommandSpy().register("cmdspy");
		new CMDReloadConfig().register("magna-reloadconfig");
		new CMDGetPos().register("getpos");
		new CMDSetWarp().register("setwarp");
		new CMDGetWarp().register("getwarp");
		new CMDRemoveWarp().register("removewarp");
		new CMDWarp().register("warp");
		new CMDWarps().register("warps");
		new CMDKickAll().register("kickall");
		new CMDMemory().register("memory");
		new CMDChatClear().register("chatclear");
		new CMDAllChatClear().register("allchatclear");
		new CMDGroups().register("magna-groups");
		new CMDMagna_Id().register("magna-id");
		new CMDMagna_List().register("magna-list");
		new CMDGroup_Exec().register("magna-group-exec");
		new CMDTeamChat().register("teamchat");
		new CMDSetSpawn().register("setspawn");
		new CMDSpawn().register("spawn");
		new CMDDay().register("day");
		new CMDNight().register("night");
		new CMDBroadcast().register("broadcast");
		new CMDGameModeInfo().register("gamemodeinfo");
		new CMDRepair().register("repair");
		new CMDOps().register("ops");
		new CMDBans().register("bans");
		new CMDBanIps().register("banips");
		new CMDSkull().register("skull");
		new CMDTpTo().register("tpto");
		new CMDTpHere().register("tphere");
		new CMDgetUUID().register("getuuid");
		new CMDTrash().register("trash");
		new CMDOpenEnderChest().register("enderchest");
		new CMDOpenWorkbench().register("workbench");
		new CMDGoDeathBack().register("deathback");
		new CMDCensor().register("censor");
		new CMDGameMode().register("gamemode");
		new CMDPardon().register("pardon");
		new CMDDamage().register("damage");
		new CMDMSG().register("msg");
		new CMDMSGR().register("msgr");
		new CMDAFK().register("afk");
		new CMDIsAFK().register("isafk");
		new CMDSetHome().register("sethome");
		new CMDHomes().register("homes");
		new CMDDeleteHome().register("deletehome");
		new CMDHome().register("home");
		new CMDOnlyBreak().register("onlybreak");
		new CMDVersion().register("magna-version");
		new CMDSpeed().register("speed");
		new CMDFlySpeed().register("flyspeed");
		new CMDWayPoint().register("waypoint");
	}

	public void registerListener() {
		new GodMode().register();
		new MutePlayer().register();
		new CommandSpying().register();
		new ChatColor().register();
		new ColorSign().register();
		new LogCommands().register();
		new DeathBack().register();
		new NoFallDamage().register();
		new AutoEdit().register();
		new BlackList().register();
		new AFK().register();
		new SignManipulator().register();
		new OnlyBreak().register();
		new GuiController().register();
	}

	public void registerRunners() {
		new AfkTestRunner().register("AfkTestRunner");
	}

	public void registerSignListener() {
		new WarpSign().register("Warp");
		new TrashSign().register("Trash");
	}

	public void startRunners() {
		Magna.getRunnerManager().startRunnerTimmer("AfkTestRunner", 20 * 10L);
	}

}
