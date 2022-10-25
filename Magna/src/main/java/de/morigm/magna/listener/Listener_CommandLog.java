package de.morigm.magna.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_CommandLog extends ListenerHelper {
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e) {
		if (Main.getInstance().getDefaultPluginConfig().commandlog)
			Main.getInstance().getCommandsLoger().addLine("<" + e.getPlayer().getName() + ">" + e.getMessage());
	}
}
