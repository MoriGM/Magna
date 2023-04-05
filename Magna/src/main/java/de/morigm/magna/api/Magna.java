package de.morigm.magna.api;

import de.morigm.magna.Main;
import de.morigm.magna.api.command.CommandUtil;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.manager.*;
import de.morigm.magna.api.memory.MemoryManager;
import de.morigm.magna.api.settings.Folders;
import de.morigm.magna.api.settings.Settings;
import de.morigm.magna.api.user.User;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Magna {

	private static final String[] spigot_versions = { "v1_19_R1" };
	@Getter
	private static CommandUtil commandUtil;
	@Getter
	private static Settings settings;
	@Getter
	private static Folders folders;
	@Getter
	private final static String name = "Magna";

	static {
		Magna.commandUtil = new CommandUtil();
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

	public static AFK getAFKManager() {
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
		return Arrays.binarySearch(Magna.getSupportedVersions(), getServerVersion()) != -1;
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
