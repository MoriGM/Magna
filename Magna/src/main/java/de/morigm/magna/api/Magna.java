package de.morigm.magna.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.command.CommandUtil;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.manager.AFKManager;
import de.morigm.magna.api.manager.AutoEditManager;
import de.morigm.magna.api.manager.BlackListManager;
import de.morigm.magna.api.manager.CommandSpyManager;
import de.morigm.magna.api.manager.DeathBackManager;
import de.morigm.magna.api.manager.GodModeManager;
import de.morigm.magna.api.manager.GroupManager;
import de.morigm.magna.api.manager.HomeManager;
import de.morigm.magna.api.manager.MSGManager;
import de.morigm.magna.api.manager.MutedPlayerManager;
import de.morigm.magna.api.manager.OnlyBreakManager;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.manager.RunnerManager;
import de.morigm.magna.api.manager.SignManager;
import de.morigm.magna.api.manager.WarpManager;
import de.morigm.magna.api.manager.WayPointManager;
import de.morigm.magna.api.memory.MemoryManager;
import de.morigm.magna.api.settings.Folders;
import de.morigm.magna.api.settings.Settings;
import de.morigm.magna.api.user.User;
import lombok.Getter;

public class Magna {

	private static final String[] spigot_versions = { "v1_18_R1" };
	private static CommandUtil commandutil;
	@Getter
	private static Settings settings;
	@Getter
	private static Folders folders;
	@Getter
	private final static String name = "Magna";

	static {
		Magna.commandutil = new CommandUtil();
		Magna.settings = new Settings(getMain());
		Magna.folders = new Folders();
	}

	public static GroupManager getGroupManager() {
		return getMain().getGroupManager();
	}

	public static MemoryManager getMemoryManager() {
		return getMain().getMemoryManager();
	}

	public static WarpManager getWarpManager() {
		return getMain().getWarpManager();
	}

	public static MutedPlayerManager getMutedPlayerManager() {
		return getMain().getMutedPlayerManager();
	}

	public static GodModeManager getGodModeManager() {
		return getMain().getGodModeManager();
	}

	public static CommandSpyManager getCommandSpyManager() {
		return getMain().getCommandSpyManager();
	}

	public static PermissionManager getPermissionManager() {
		return getMain().getPermissionManager();
	}

	public static DeathBackManager getDeathBackManager() {
		return getMain().getDeathBackManager();
	}

	public static AutoEditManager getAutoEditManager() {
		return getMain().getAutoEditManager();
	}

	public static MSGManager getMSGManager() {
		return getMain().getMSGManager();
	}

	public static BlackListManager getBlackListManager() {
		return getMain().getBlackListManager();
	}

	public static RunnerManager getRunnerManager() {
		return getMain().getRunnerManager();
	}

	public static AFKManager getAFKManager() {
		return getMain().getAFKManager();
	}

	public static HomeManager getHomeManager() {
		return getMain().getHomeManager();
	}

	public static SignManager getSignManager() {
		return getMain().getSignManager();
	}

	public static OnlyBreakManager getOnlyBreakManager() {
		return getMain().getOnlyBreakManager();
	}

	public static WayPointManager GetWayPointManager() {
		return getMain().getWayPointManager();
	}

	public static Language getLanguage() {
		return getMain().getLanguage();
	}

	public static String getServerVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
	}

	public static String[] getSupportedVersions() {
		return spigot_versions;
	}

	public static boolean isSupported() {
		for (String s : spigot_versions)
			if (s.equals(getServerVersion()))
				return true;
		return false;
	}

	public static CommandUtil getCommandUtil() {
		return Magna.commandutil;
	}

	public static User getUser(Player p) {
		return getUser(p, getPermissionManager());
	}

	public static User getUser(Player p, PermissionManager manager) {
		return new User(p, manager);
	}

	private static Main getMain() {
		return Main.getInstance();
	}

}
