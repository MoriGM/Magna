package de.morigm.magna.listener;

import static de.morigm.magna.api.Magna.getAFKManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_AFK extends ListenerHelper
{

	@EventHandler
	public void testIfAFK(PlayerMoveEvent e)
	{
		if(!getAFKManager().containsLocation(e.getPlayer()))
			getAFKManager().setLocation(e.getPlayer(), e.getPlayer().getLocation());
		if(!getAFKManager().containsTime(e.getPlayer()))
			getAFKManager().setTime(e.getPlayer(), System.currentTimeMillis());
		
		if(!getAFKManager().isAfk(e.getPlayer()))
			getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void testIfAFK(BlockPlaceEvent e)
	{
		getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void testIfAFK(BlockBreakEvent e)
	{
		getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void testIfAFK(AsyncPlayerChatEvent e)
	{
		getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void testIfAFK(PlayerCommandPreprocessEvent e)
	{
		getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void testIfAFK(InventoryOpenEvent e)
	{
		Player t = (Player) e.getPlayer();
		getAFKManager().setTimeAndLocation(t, e.getPlayer().getLocation(), System.currentTimeMillis());
	}
	
	@EventHandler
	public void testIfNotAFK(PlayerMoveEvent e)
	{
		if(getAFKManager().isAfk(e.getPlayer()) && (getAFKManager().getLocation(e.getPlayer()).getBlockX() != e.getPlayer().getLocation().getBlockX() || getAFKManager().getLocation(e.getPlayer()).getBlockY() != e.getPlayer().getLocation().getBlockY() || getAFKManager().getLocation(e.getPlayer()).getBlockZ() != e.getPlayer().getLocation().getBlockZ()))
		{
			getAFKManager().removePlayerFromAFKMode(e.getPlayer());
			getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
		}
	}
	
	@EventHandler
	public void testIfNotAFK(BlockPlaceEvent e)
	{
		if(getAFKManager().isAfk(e.getPlayer()))
		{
			getAFKManager().removePlayerFromAFKMode(e.getPlayer());
			getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
		}
	}
	
	@EventHandler
	public void testIfNotAFK(BlockBreakEvent e)
	{
		if(getAFKManager().isAfk(e.getPlayer()))
		{
			getAFKManager().removePlayerFromAFKMode(e.getPlayer());
			getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
		}
	}
	
	@EventHandler
	public void testIfNotAFK(AsyncPlayerChatEvent e)
	{
		if(getAFKManager().isAfk(e.getPlayer()))
		{
			getAFKManager().removePlayerFromAFKMode(e.getPlayer());
			getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
		}
	}
	
	@EventHandler
	public void testIfNotAFK(PlayerCommandPreprocessEvent e)
	{
		if(getAFKManager().isAfk(e.getPlayer()) && !e.getMessage().startsWith("/afk"))
		{
			getAFKManager().removePlayerFromAFKMode(e.getPlayer());
			getAFKManager().setTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(), System.currentTimeMillis());
		}
	}
	
	@EventHandler
	public void testIfNotAFK(InventoryOpenEvent e)
	{
		Player t = (Player) e.getPlayer();
		if(getAFKManager().isAfk(t))
		{
			getAFKManager().removePlayerFromAFKMode(t);
			getAFKManager().setTimeAndLocation(t, t.getLocation(), System.currentTimeMillis());
		}
	}
	
	@EventHandler
	public void on(PlayerQuitEvent e)
	{
		if(getAFKManager().containsLocation(e.getPlayer()))
			getAFKManager().getLastPlayerTimes().remove(e.getPlayer());
		if(getAFKManager().containsLocation(e.getPlayer()))
			getAFKManager().getLastPlayerPositions().remove(e.getPlayer());
		if(getAFKManager().isAfk(e.getPlayer()))
			getAFKManager().removePlayerFromAFKMode(e.getPlayer());
	}
	
}
