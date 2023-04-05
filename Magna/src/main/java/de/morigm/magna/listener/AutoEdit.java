package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.listner.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AutoEdit extends Listener {
    @EventHandler
    public void on(AsyncPlayerChatEvent e) {
        if (Main.getInstance().getDefaultPluginConfig().autoedit)
            e.setMessage(Main.getInstance().getAutoEditManager().getChangesFromEdit(e.getMessage(), e.getPlayer()));
    }
}
