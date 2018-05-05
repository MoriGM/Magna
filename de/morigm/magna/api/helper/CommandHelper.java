package de.morigm.magna.api.helper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.Main;

public interface CommandHelper extends CommandExecutor
{

	public default void register(String cmd_name)
	{
		this.register(cmd_name, Main.getInstance());
	}
	
	public default void register(String cmd_name,JavaPlugin javaPlugin)
	{
		javaPlugin.getCommand(cmd_name).setExecutor(javaPlugin);
	}
	
}
