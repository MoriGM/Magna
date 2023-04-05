package de.morigm.magna.listener;

import de.morigm.magna.api.helper.ListenerHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColor extends ListenerHelper {
	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		if (e.getPlayer().hasPermission(getPermission("chatcolor")))
			e.setMessage(e.getMessage().replaceAll("&", "§"));
	}

}
