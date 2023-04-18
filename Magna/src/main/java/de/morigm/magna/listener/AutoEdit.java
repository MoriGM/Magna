package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.listner.Listener;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.event.EventHandler;

public class AutoEdit extends Listener {
    @EventHandler
    public void on(AsyncChatEvent e) {
        if (Main.getInstance().getDefaultPluginConfig().autoedit) {
            TextComponent msg = (TextComponent) e.message();
            e.message(Component.text(Main.getInstance().getAutoEditManager().getChangesFromEdit(msg.content(), e.getPlayer())));
        }
    }
}
