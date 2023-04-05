package de.morigm.magna.listener;

import de.morigm.magna.api.listner.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColor extends Listener {
    @EventHandler
    public void on(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission(getPermission("chatcolor")))
            e.setMessage(e.getMessage().replaceAll("&", "§"));
    }

}
