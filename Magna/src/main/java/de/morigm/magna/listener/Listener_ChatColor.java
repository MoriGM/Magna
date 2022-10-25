package de.morigm.magna.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_ChatColor extends ListenerHelper {
	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		if (e.getPlayer().hasPermission(getPermission("chatcolor")))
			e.setMessage(e.getMessage().replaceAll("&", "§"));
	}

}
