package de.morigm.magna.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_AutoEdit extends ListenerHelper 
{
	@EventHandler
	public void on(AsyncPlayerChatEvent e)
	{
		if(Main.getInstance().getDefaultPluginConfig().autoedit)
			e.setMessage(Main.getInstance().getAutoEditManager().getChangesFromEdit(e.getMessage(), e.getPlayer()));
	}
}
