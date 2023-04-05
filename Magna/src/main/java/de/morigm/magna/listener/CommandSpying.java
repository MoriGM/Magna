package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandSpying extends ListenerHelper {
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (Main.getInstance().getCommandSpyManager().containsPlayer(p))
				if (!Main.getInstance().getDefaultPluginConfig().commandspyblocked
						.contains(e.getMessage().split(" ")[0])) {
					if (!Main.getInstance().getDefaultPluginConfig().owncommandspy) {
						if (!p.equals(e.getPlayer()))
							p.sendMessage(Chat.prefix + ChatColor.GRAY + "<" + ChatColor.GREEN + e.getPlayer().getName()
									+ ChatColor.GRAY + ">" + ChatColor.WHITE + e.getMessage());
					} else
						p.sendMessage(Chat.prefix + ChatColor.GRAY + "<" + ChatColor.GREEN + e.getPlayer().getName()
								+ ChatColor.GRAY + ">" + ChatColor.WHITE + e.getMessage());
				}
		}
	}
}
