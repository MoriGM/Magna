package de.morigm.magna.api.helper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.CommandUtil;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.manager.PermissionManager;

public abstract class CommandHelper implements CommandExecutor, PermissionHelper, TranslationHelper
{

	private String name = "";
	private Language language;
	private PermissionManager permission;

	public void register(String cmd_name)
	{
		this.register(cmd_name, Main.getInstance() != null ? Magna.getLanguage() : null);
	}
	
	public void register(String cmd_name, JavaPlugin javaPlugin)
	{
		this.register(cmd_name, Main.getInstance() != null ? Magna.getLanguage() : null, Main.getInstance() != null ? Magna.getPermissionManager() : null, javaPlugin);
	}
	
	public void register(String cmd_name, Language language)
	{
		this.register(cmd_name, language, Main.getInstance() != null ? Magna.getPermissionManager() : null, Main.getInstance());
	}
	
	public void register (String cmd_name, PermissionManager permission)
	{
		this.register(cmd_name, Main.getInstance() != null ? Magna.getLanguage() : null, Magna.getPermissionManager(), Main.getInstance());
	}
	
	public void register (String cmd_name, Language language, PermissionManager permission)
	{
		this.register(cmd_name, language, permission, Main.getInstance());
	}
	
	public void register(String cmd_name, Language language, PermissionManager permission, JavaPlugin javaPlugin)
	{
		name = cmd_name;
		if (javaPlugin != null)
			javaPlugin.getCommand(cmd_name).setExecutor(this);
		if (language != null)
			this.language = language;
		if (permission != null)
			this.permission = permission;
		registerUtils();
	}
	
	public String getCommand()
	{
		return name;
	}
	
	public boolean isPlayer(CommandSender com)
	{
		return com instanceof Player;
	}
	
	public CommandUtil util()
	{
		return Magna.getCommandUtil();
	}
	
	@Override
	public String translate(String text, TextStruct ... structs) 
	{
		return language.translate(text, structs);
	}
	
	@Override
	public String getPermission(String Permission) 
	{
		return this.permission.getPermission(Permission);
	}
	
	public abstract void registerUtils();
	
	public String Slash(CommandSender sender)
	{
		return (sender instanceof Player ? "/" : "");
	}
	
}
