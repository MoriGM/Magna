package de.morigm.magna.api.helper;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.manager.PermissionManager;

public class ListenerHelper implements Listener, PermissionHelper, TranslationHelper {

	private Language language;
	private PermissionManager permission;

	public void register() {
		this.register(Main.getInstance() != null ? Magna.getLanguage() : null,
				Main.getInstance() != null ? Magna.getPermissionManager() : null, Main.getInstance());
	}

	public void register(JavaPlugin javaplugin) {
		this.register(Main.getInstance() != null ? Magna.getLanguage() : null,
				Main.getInstance() != null ? Magna.getPermissionManager() : null, javaplugin);
	}

	public void register(Language language) {
		this.register(language, Main.getInstance() != null ? Magna.getPermissionManager() : null, Main.getInstance());
	}

	public void register(PermissionManager permission) {
		this.register(Main.getInstance() != null ? Magna.getLanguage() : null, permission, Main.getInstance());
	}

	public void register(Language language, PermissionManager permission, JavaPlugin javaplugin) {
		if (language != null)
			this.language = language;
		if (permission != null)
			this.permission = permission;
		Bukkit.getPluginManager().registerEvents(this, javaplugin);
	}

	@Override
	public String translate(String text, TextStruct... structs) {
		return language.translate(text, structs);
	}

	@Override
	public String getPermission(String Permission) {
		return this.permission.getPermission(Permission);
	}
}
