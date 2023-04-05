package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MutePlayer extends ListenerHelper {

	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		if (Main.getInstance().getMutedPlayerManager().containsPlayer(e.getPlayer())) {
			e.getPlayer().sendMessage(Chat.prefix + translate("listener.mute"));
			e.setCancelled(true);
		}
	}

}
