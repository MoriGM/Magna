package de.morigm.magna.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_GODMODE extends ListenerHelper
{
	@EventHandler
	public void on(PlayerInteractEvent e)
	{
		if (Main.getInstance().getGodModeManager().containsPlayer(e.getPlayer()))
			if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) && e.getClickedBlock() != null)
				if (!e.getClickedBlock().getType().equals(Material.BEDROCK))
					e.getClickedBlock().breakNaturally();
	}
	
	@EventHandler
	public void on(EntityDamageEvent e)
	{
		if (e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if (Main.getInstance().getGodModeManager().containsPlayer(p))
				e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e)
	{
		if (e.getDamager() instanceof Player)
		{
			Player p = (Player) e.getDamager();
			if (Main.getInstance().getGodModeManager().containsPlayer(p))
				e.setDamage(10000000D);
		}
	}
	
	@EventHandler
	public void on(FoodLevelChangeEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if (Main.getInstance().getGodModeManager().containsPlayer(p))
				e.setCancelled(true);
		}
	}
}
