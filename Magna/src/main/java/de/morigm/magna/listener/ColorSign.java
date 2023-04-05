package de.morigm.magna.listener;

import de.morigm.magna.api.helper.ListenerHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;

public class ColorSign extends ListenerHelper {
	@EventHandler
	public void on(SignChangeEvent e) {
		if (e.getPlayer().hasPermission(getPermission("colorsign"))) {
			for (int i = 0; i < 4; i++)
				e.setLine(i, e.getLine(i).replaceAll("&", "§"));
		}
	}
}
