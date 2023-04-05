package de.morigm.magna.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ConfigHelper;

public class PluginConfig implements ConfigHelper {

	public List<String> commandspyblocked;
	public List<String> groups;
	public List<String> nofalldamage;
	public boolean owncommandspy;
	public boolean commandlog;
	public boolean chatclear;
	public boolean warning;
	public boolean autoedit;
	public boolean blacklistperm;
	public boolean showafk;
	public Location spawn;
	public String language;
	public int afkTimer;
	public boolean debug;

	private void adddefault() {
		getConfig().options().copyDefaults(true);

		getConfig().addDefault("owncommandspy", false);
		getConfig().addDefault("commandlog", false);
		getConfig().addDefault("chatclear", false);
		getConfig().addDefault("warning", true);
		getConfig().addDefault("blacklistperm", false);
		getConfig().addDefault("autoedit", true);
		getConfig().addDefault("showafk", true);
		getConfig().addDefault("commandspyblocked", new ArrayList<String>());
		getConfig().addDefault("nofalldamage", new ArrayList<String>());
		getConfig().addDefault("language", "en-en.yml");
		getConfig().addDefault("afk-timer", 5);
	}

	@Override
	public void load() {
		this.adddefault();
		this.commandspyblocked = getConfig().getStringList("commandspyblocked");
		this.owncommandspy = getConfig().getBoolean("owncommandspy");
		this.commandlog = getConfig().getBoolean("commandlog");
		this.chatclear = getConfig().getBoolean("chatclear");
		this.warning = getConfig().getBoolean("warning");
		this.groups = getConfig().getStringList("groups");
		this.language = getConfig().getString("language");
		this.nofalldamage = getConfig().getStringList("nofalldamage");
		this.autoedit = getConfig().getBoolean("autoedit");
		this.blacklistperm = getConfig().getBoolean("blacklistperm");
		this.afkTimer = getConfig().getInt("afk-timer");
		this.showafk = getConfig().getBoolean("showafk");
		if (getConfig().contains("debug"))
			this.debug = getConfig().getBoolean("debug");
		else
			this.debug = true;

		loadSpawn();
	}

	private void loadSpawn() {
		if (getConfig().contains("spawn.x") && getConfig().contains("spawn.y") && getConfig().contains("spawn.z")
				&& getConfig().contains("spawn.yaw") && getConfig().contains("spawn.pitch")
				&& getConfig().contains("spawn.world")) {
			float pitch = (float) getConfig().getDouble("spawn.pitch");
			float yaw = (float) getConfig().getDouble("spawn.yaw");
			int x = getConfig().getInt("spawn.x");
			int y = getConfig().getInt("spawn.y");
			int z = getConfig().getInt("spawn.z");
			String world = getConfig().getString("spawn.world");

			Location loc = new Location(Bukkit.getWorld(world), x, y, z);
			loc.setYaw(yaw);
			loc.setPitch(pitch);

			this.spawn = loc;
		}
	}

	@Override
	public void save() {
		if (this.spawn != null)
			savespawn();
		getConfig().set("commandspyblocked", this.commandspyblocked);
		getConfig().set("owncommandspy", this.owncommandspy);
		getConfig().set("commandlog", this.commandlog);
		getConfig().set("chatclear", this.chatclear);
		getConfig().set("groups", this.groups);
		getConfig().set("warning", this.warning);
		getConfig().set("nofalldamage", this.nofalldamage);
		getConfig().set("autoedit", this.autoedit);
		getConfig().set("blacklistperm", this.blacklistperm);
		getConfig().set("afk-timer", this.afkTimer);
		getConfig().set("showafk", this.showafk);
		Main.getInstance().saveConfig();
	}

	private void savespawn() {
		getConfig().set("spawn.x", this.spawn.getBlockX());
		getConfig().set("spawn.y", this.spawn.getBlockY());
		getConfig().set("spawn.z", this.spawn.getBlockZ());
		getConfig().set("spawn.yaw", this.spawn.getYaw());
		getConfig().set("spawn.pitch", this.spawn.getPitch());
		getConfig().set("spawn.world", this.spawn.getWorld().getName());
	}

	public FileConfiguration getConfig() {
		return Main.getInstance().getConfig();
	}

}
