package de.morigm.magna.api.helper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.Main;
import de.morigm.magna.api.manager.GroupManager;

public abstract class CommandHelper implements CommandExecutor,PermissionHelper
{

	String name = "";

	public void register(String cmd_name)
	{
		this.register(cmd_name, Main.getInstance());
	}
	
	public void register(String cmd_name,JavaPlugin javaPlugin)
	{
		name = cmd_name;
		javaPlugin.getCommand(cmd_name).setExecutor(this);
	}
	
	public String getCommand()
	{
		return name;
	}
	
	public GroupManager getGroupManager()
	{
		return Main.getInstance().getGroupManager();
	}
	
	public String translate(String text)
	{
		return Main.getInstance().getLanguage().translate(text);
	}
	
}
