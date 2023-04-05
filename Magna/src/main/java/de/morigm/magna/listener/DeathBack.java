package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathBack extends Listener {
	@EventHandler
	public void on(PlayerDeathEvent e) {
		Main.getInstance().getDeathBackManager().setDeathBack(e.getEntity(), e.getEntity().getLocation());
	}
}
