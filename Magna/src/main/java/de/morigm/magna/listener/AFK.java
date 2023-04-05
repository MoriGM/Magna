package de.morigm.magna.listener;

import static de.morigm.magna.api.Magna.getAFKManager;

import org.bukkit.Location;
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

public class AFK extends ListenerHelper {

	@EventHandler
	public void testIfAFK(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (!getAFKManager().containsLocation(player)) {
			getAFKManager().setLocation(player, player.getLocation());
		}
		if (!getAFKManager().containsTime(player)) {
			getAFKManager().setTime(player, System.currentTimeMillis());
		}
		if (!getAFKManager().isAfk(player)) {
			getAFKManager().updateTimeAndLocation(player, player.getLocation(), System.currentTimeMillis());
		}
	}

	@EventHandler
	public void testIfAFK(BlockPlaceEvent e) {
		getAFKManager().updateCurrentPlayer(e.getPlayer());
	}

	@EventHandler
	public void testIfAFK(BlockBreakEvent e) {
		getAFKManager().updateCurrentPlayer(e.getPlayer());
	}

	@EventHandler
	public void testIfAFK(AsyncPlayerChatEvent e) {
		getAFKManager().updateCurrentPlayer(e.getPlayer());
	}

	@EventHandler
	public void testIfAFK(PlayerCommandPreprocessEvent e) {
		getAFKManager().updateCurrentPlayer(e.getPlayer());
	}

	@EventHandler
	public void testIfAFK(InventoryOpenEvent e) {
		Player t = (Player) e.getPlayer();
		getAFKManager().updateCurrentPlayer(t);
	}

	@EventHandler
	public void testIfNotAFK(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (!getAFKManager().isAfk(player)) {
			return;
		}

		Location oldLocation = getAFKManager().getLocation(player);
		Location currentLocation = player.getLocation();

		if ((oldLocation.getBlockX() != currentLocation.getBlockX()
				|| oldLocation.getBlockY() != currentLocation.getBlockY()
				|| oldLocation.getBlockZ() != currentLocation.getBlockZ())) {
			getAFKManager().removePlayer(player);
			getAFKManager().updateCurrentPlayer(player);
		}
	}

	@EventHandler
	public void testIfNotAFK(BlockPlaceEvent e) {
		if (getAFKManager().isAfk(e.getPlayer())) {
			getAFKManager().removePlayer(e.getPlayer());
			getAFKManager().updateCurrentPlayer(e.getPlayer());
		}
	}

	@EventHandler
	public void testIfNotAFK(BlockBreakEvent e) {
		if (getAFKManager().isAfk(e.getPlayer())) {
			getAFKManager().removePlayer(e.getPlayer());
			getAFKManager().updateCurrentPlayer(e.getPlayer());
		}
	}

	@EventHandler
	public void testIfNotAFK(AsyncPlayerChatEvent e) {
		if (getAFKManager().isAfk(e.getPlayer())) {
			getAFKManager().removePlayer(e.getPlayer());
			getAFKManager().updateTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(),
					System.currentTimeMillis());
		}
	}

	@EventHandler
	public void testIfNotAFK(PlayerCommandPreprocessEvent e) {
		if (getAFKManager().isAfk(e.getPlayer()) && !e.getMessage().startsWith("/afk")) {
			getAFKManager().removePlayer(e.getPlayer());
			getAFKManager().updateTimeAndLocation(e.getPlayer(), e.getPlayer().getLocation(),
					System.currentTimeMillis());
		}
	}

	@EventHandler
	public void testIfNotAFK(InventoryOpenEvent e) {
		Player t = (Player) e.getPlayer();
		if (getAFKManager().isAfk(t)) {
			getAFKManager().removePlayer(t);
			getAFKManager().updateTimeAndLocation(t, t.getLocation(), System.currentTimeMillis());
		}
	}

	@EventHandler
	public void on(PlayerQuitEvent e) {
		if (getAFKManager().containsLocation(e.getPlayer())) {
			getAFKManager().getLastPlayerTimes().remove(e.getPlayer());
		}
		if (getAFKManager().containsLocation(e.getPlayer())) {
			getAFKManager().getLastPositions().remove(e.getPlayer());
		}
		if (getAFKManager().isAfk(e.getPlayer())) {
			getAFKManager().removePlayer(e.getPlayer());
		}
	}

}
