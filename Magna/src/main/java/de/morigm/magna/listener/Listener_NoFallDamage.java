package de.morigm.magna.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_NoFallDamage extends ListenerHelper {
	@EventHandler
	public void on(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player)
			if (e.getCause().equals(DamageCause.FALL))
				if (Main.getInstance().getDefaultPluginConfig().nofalldamage
						.contains(e.getEntity().getWorld().getName()))
					e.setCancelled(true);
	}
}
