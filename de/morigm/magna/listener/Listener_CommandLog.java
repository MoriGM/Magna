package de.morigm.magna.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_CommandLog implements ListenerHelper
{
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e)
	{
		Main.getInstance().getCommandsLoger().addLine("<" + e.getPlayer().getName() + ">" + e.getMessage());
	}
}
