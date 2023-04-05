package de.morigm.magna.listener;

import de.morigm.magna.api.items.ItemIs;
import de.morigm.magna.api.helper.ListenerHelper;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import static de.morigm.magna.api.Magna.getOnlyBreakManager;

public class OnlyBreak extends ListenerHelper {

	@EventHandler
	public void on(BlockBreakEvent e) {
		if (getOnlyBreakManager().containsPlayer(e.getPlayer()) && e.getPlayer().getInventory().getItemInMainHand() != null && !e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
			e.setCancelled(!ItemIs.equalType(e.getPlayer().getInventory().getItemInMainHand(), e.getBlock().getType()));
		}
	}

}
