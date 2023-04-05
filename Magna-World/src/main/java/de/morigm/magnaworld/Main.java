package de.morigm.magnaworld;

import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magnaworld.loader.LanguageLoader;
import de.morigm.magnaworld.loader.PluginLoader;
import de.morigm.magnaworld.loader.WorldLoader;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

	@Getter
	private static Main instance;
	@Getter
	private File folder;
	@Getter
	private File WorldFolder;
	@Getter
	private PluginLoader WorldPluginLoader;
	@Setter
	@Getter
	private Language language;
	@Getter
	private PermissionManager permission;
	@Getter
	private File LanguageFolder;
	@Getter
	private LanguageLoader languageLoader;
	@Getter
	private WorldLoader WorldLoader;

	@Override
	public void onEnable() {
		Main.instance = this;

		this.folder = getDataFolder();
		this.WorldFolder = new File(folder, "worlds");
		this.LanguageFolder = new File(folder, "language");
		this.WorldFolder.mkdirs();
		this.LanguageFolder.mkdirs();

		(this.WorldLoader = new WorldLoader()).load();
		(this.permission = new PermissionManager(getResource("Permission.yml"))).load();
		(this.languageLoader = new LanguageLoader()).load();
		this.WorldPluginLoader = new PluginLoader();
		this.WorldPluginLoader.loadCommands();
		this.WorldPluginLoader.loadListener();

	}

	@Override
	public void onDisable() {
		this.WorldLoader.save();
	}
}
