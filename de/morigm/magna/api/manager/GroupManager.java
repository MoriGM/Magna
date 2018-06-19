package de.morigm.magna.api.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.morigm.magna.Main;
import de.morigm.magna.api.group.Group;

public class GroupManager 
{
	
	public boolean isPlayerInGroup(Player p)
	{
		return getGroupFromPlayer(p) != null;
	}
	
	public Group getGroupFromPlayer(Player p)
	{
		for(Group group : Main.getInstance().getGroupLoader().getGroups())
			if(p.hasPermission(group.permission))
				return group;
		return null;
	}
	
	public boolean isPlayerInGroup(Player p,String group_name)
	{
		return getGroupFromPlayer(p).name.equals(group_name);
	}
	
	public Group[] getGroups()
	{
		return Main.getInstance().getGroupLoader().getGroups();
	}
	
	public Map<Player,Group> getOnlinePlayerWithGroup()
	{
		Map<Player,Group> map = new HashMap<>();
		for(Player p : Bukkit.getOnlinePlayers())
			map.put(p, getGroupFromPlayer(p));
		return map;
	}
	
	public List<Player> getPlayersByGroup(Group group)
	{
		List<Player> players = new ArrayList<>();
		for(Player t : Bukkit.getOnlinePlayers())
			if(t.hasPermission(group.permission))
				players.add(t);
		return players;
	}
	
	public Group getGroup(String group)
	{
		for(Group groups : getGroups())
			if(groups.name.equals(group))
				return groups;
		return null;
	}
	
}
