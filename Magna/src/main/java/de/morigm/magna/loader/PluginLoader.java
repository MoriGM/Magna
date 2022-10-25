package de.morigm.magna.loader;

import de.morigm.magna.api.Magna;
import de.morigm.magna.commands.*;
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
