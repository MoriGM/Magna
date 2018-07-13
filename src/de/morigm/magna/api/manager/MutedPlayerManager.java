package de.morigm.magna.api.manager;

import org.bukkit.entity.Player;

import de.morigm.magna.Main;

public class MutedPlayerManager 
{
	public void addPlayer(Player p)
	{
		if(!Main.getInstance().getPlayerConfig().muted.contains(p.getUniqueId().toString()))
			Main.getInstance().getPlayerConfig().muted.add(p.getUniqueId().toString());
	}
	
	public void removePlayer(Player p)
	{
		if(Main.getInstance().getPlayerConfig().muted.contains(p.getUniqueId().toString()))
			Main.getInstance().getPlayerConfig().muted.remove(p.getUniqueId().toString());
	}
	
	public boolean containsPlayer(Player p)
	{
		return Main.getInstance().getPlayerConfig().muted.contains(p.getUniqueId().toString());
	}
	
	public void togglePlayer(Player p)
	{
		if(this.containsPlayer(p))
			this.removePlayer(p);
		else
			this.addPlayer(p);
	}
}
