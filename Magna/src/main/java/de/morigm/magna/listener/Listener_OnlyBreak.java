package de.morigm.magna.listener;

import static de.morigm.magna.api.Magna.getOnlyBreakManager;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import de.morigm.magna.api.helper.ItemHelper;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_OnlyBreak extends ListenerHelper
{
	
	@EventHandler
	public void on(BlockBreakEvent e)
	{
		if (getOnlyBreakManager().containsPlayer(e.getPlayer()) && e.getPlayer().getInventory().getItemInMainHand() != null && !e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR))
			e.setCancelled(!ItemHelper.equalsType(e.getPlayer().getInventory().getItemInMainHand(), e.getBlock().getType()));
	}

}
