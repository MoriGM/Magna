package de.morigm.magna.api.settings;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import de.morigm.magna.Main;
import de.morigm.magna.config.PluginConfig;

public class Settings 
{
	
	private PluginConfig config;

	public Settings(Main main) 
	{
		if (main != null)
			this.config = main.getDefaultPluginConfig();
	}
	
	public boolean getOwnCommandSpy()
	{
		if (this.config != null) 	return config.owncommandspy;
		else						return false;
	}
	
	public List<String> getCommandSpyBlocked()
	{
		if (this.config != null)	return config.commandspyblocked;
		else						return new ArrayList<>();
	}
	
	public List<String> getNoFallDamageWorlds()
	{
		if (this.config != null)	return config.nofalldamage;
		else						return new ArrayList<>();
	}
	
	public boolean getBlackListPermission()
	{
		if (this.config != null)	return config.blacklistperm;
		else						return false;
	}
	
	public boolean getWarning()
	{
		if (this.config != null)	return config.warning;
		else						return false;
	}
	
	public boolean getShowChatClear()
	{
		if (this.config != null)	return config.chatclear;
		else						return false;
	}
	
	public Location getSpawn()
	{
		if (this.config != null)	return config.spawn;
		else						return new Location(null, 0, 0, 0);
	}
	
	public String getLanguage()
	{
		if (this.config != null) 	return config.language;
		else 						return "en-en.yml";
	}
	
	public int getAFKTimer()
	{
		if (this.config != null)	return config.afkTimer;
		else						return 5;
	}
	public boolean getShowAfk()
	{
		if (this.config != null)	return config.showafk;
		else						return false;
	}
	
	public boolean getDebug()
	{
		if (this.config != null)	return config.debug;
		else						return false;
	}
	
	public void setOwnCommandSpy(boolean state)
	{
		if (this.config != null)
			config.owncommandspy = state;
	}
	
	public void setBlackListPermission(boolean state)
	{
		if (this.config != null)
			config.blacklistperm = state;
	}
	
	public void setWarning(boolean state)
	{
		if (this.config != null)
			config.warning = state;
	}
	
	public void setShowChatClear(boolean state)
	{
		if (this.config != null)
			config.chatclear = state;
	}
	
	public void setShowAfk(boolean state)
	{
		if (this.config != null)
			config.showafk = state;
	}
	
	public void setSpawn(Location spawn)
	{
		if (this.config != null)
			config.spawn = spawn;
	}
	
	public void setAFKTimer(int i)
	{
		if (this.config != null)
			config.afkTimer = i;
	}

}
