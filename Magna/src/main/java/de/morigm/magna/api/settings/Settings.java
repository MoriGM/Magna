package de.morigm.magna.api.settings;

import java.util.List;

import org.bukkit.Location;

import de.morigm.magna.Main;

public class Settings 
{
	
	private Main main;

	public Settings(Main main) 
	{
		this.main = main;
	}
	
	public boolean getOwnCommandSpy()
	{
		return main.getDefaultPluginConfig().owncommandspy;
	}
	
	public List<String> getCommandSpyBlocked()
	{
		return main.getDefaultPluginConfig().commandspyblocked;
	}
	
	public List<String> getNoFallDamageWorlds()
	{
		return main.getDefaultPluginConfig().nofalldamage;
	}
	
	public boolean getBlackListPermission()
	{
		return main.getDefaultPluginConfig().blacklistperm;
	}
	
	public boolean getWarning()
	{
		return main.getDefaultPluginConfig().warning;
	}
	
	public Location getSpawn()
	{
		return main.getDefaultPluginConfig().spawn;
	}
	
	public void setOwnCommandSpy(boolean state)
	{
		main.getDefaultPluginConfig().owncommandspy = state;
	}
	
	public void setBlackListPermission(boolean state)
	{
		main.getDefaultPluginConfig().blacklistperm = state;
	}
	
	public void setWarning(boolean state)
	{
		main.getDefaultPluginConfig().warning = state;
	}
	
	public void setSpawn(Location spawn)
	{
		main.getDefaultPluginConfig().spawn = spawn;
	}

}
