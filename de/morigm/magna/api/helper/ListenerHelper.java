package de.morigm.magna.api.helper;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.Main;

public interface ListenerHelper extends Listener,PermissionHelper
{
	
	public default void register()
	{
		this.register(Main.getInstance());
	}
	
	public default void register(JavaPlugin javaplugin)
	{
		Bukkit.getPluginManager().registerEvents(this, javaplugin);
	}
	
	public default String getPermission(String Permission)
	{
		return Main.getInstance().getPermissionManager().getPermission(Permission);
	}
	
}
