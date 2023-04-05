package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class LogCommands extends Listener {
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e) {
		if (Main.getInstance().getDefaultPluginConfig().commandlog)
			Main.getInstance().getCommandsLoger().addLine("<" + e.getPlayer().getName() + ">" + e.getMessage());
	}
}
