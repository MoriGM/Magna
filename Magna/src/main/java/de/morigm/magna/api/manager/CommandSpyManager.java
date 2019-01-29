package de.morigm.magna.api.manager;

import org.bukkit.entity.Player;

import de.morigm.magna.Main;

public class CommandSpyManager 
{

	public void addPlayer(Player p)
	{
		if (!Main.getInstance().getPlayerConfig().cmdspy.contains(p.getUniqueId().toString()))
			Main.getInstance().getPlayerConfig().cmdspy.add(p.getUniqueId().toString());
	}
	
	public void removePlayer(Player p)
	{
		if (Main.getInstance().getPlayerConfig().cmdspy.contains(p.getUniqueId().toString()))
			Main.getInstance().getPlayerConfig().cmdspy.remove(p.getUniqueId().toString());
	}
	
	public boolean containsPlayer(Player p)
	{
		return Main.getInstance().getPlayerConfig().cmdspy.contains(p.getUniqueId().toString());
	}
	
	public void togglePlayer(Player p)
	{
		if (this.containsPlayer(p))
			this.removePlayer(p);
		else
			this.addPlayer(p);
	}
	
}
