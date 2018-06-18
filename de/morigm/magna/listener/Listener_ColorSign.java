package de.morigm.magna.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;

import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_ColorSign implements ListenerHelper
{
	@EventHandler 
	public void on(SignChangeEvent e)
	{
		if(e.getPlayer().hasPermission(getPermission("colorsign")))
		{
			for(int i = 0;i < 4;i++)
				e.setLine(i, e.getLine(i).replaceAll("&", "$"));
		}
	}
}
