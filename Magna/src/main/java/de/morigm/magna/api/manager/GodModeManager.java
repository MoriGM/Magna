package de.morigm.magna.api.manager;

import java.util.List;

import org.bukkit.entity.Player;

import de.morigm.magna.Main;

public class GodModeManager 
{
	public void addPlayer(Player p)
	{
		if(!getPlayers().contains(p.getUniqueId().toString()))
			getPlayers().add(p.getUniqueId().toString());
	}
	
	public void removePlayer(Player p)
	{
		if(getPlayers().contains(p.getUniqueId().toString()))
			getPlayers().remove(p.getUniqueId().toString());
	}
	
	public boolean containsPlayer(Player p)
	{
		return getPlayers().contains(p.getUniqueId().toString());
	}
	
	public void togglePlayer(Player p)
	{
		if(this.containsPlayer(p))
			this.removePlayer(p);
		else
			this.addPlayer(p);
	}
	
	public List<String> getPlayers()
	{
		return Main.getInstance().getPlayerConfig().godmode;
	}

}
