package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.listner.Listener;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandSpying extends Listener {
    @EventHandler
    public void on(PlayerCommandPreprocessEvent e) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Main.Companion.getInstance().getCommandSpyManager().containsPlayer(p))
                if (!Main.Companion.getInstance().getDefaultPluginConfig().commandspyblocked
                        .contains(e.getMessage().split(" ")[0])) {
                    if (!Main.Companion.getInstance().getDefaultPluginConfig().owncommandspy) {
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
