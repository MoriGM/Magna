package de.morigm.magna.api.helper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.CommandUtil;
import de.morigm.magna.api.manager.GroupManager;

public abstract class CommandHelper implements CommandExecutor, PermissionHelper, TranslationHelper
{

	private String name = "";

	public void register(String cmd_name)
	{
		this.register(cmd_name, Main.getInstance());
	}
	
	public void register(String cmd_name,JavaPlugin javaPlugin)
	{
		name = cmd_name;
		if(javaPlugin != null)
			javaPlugin.getCommand(cmd_name).setExecutor(this);
		registerUtils();
	}
	
	public String getCommand()
	{
		return name;
	}
	
	public GroupManager getGroupManager()
	{
		return Main.getInstance().getGroupManager();
	}
	
	public boolean isPlayer(CommandSender com)
	{
		return com instanceof Player;
	}
	
	public CommandUtil util()
	{
		return Magna.getCommandUtil();
	}
	
	public abstract void registerUtils();
	
}
