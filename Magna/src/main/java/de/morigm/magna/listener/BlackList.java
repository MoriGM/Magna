package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.events.PlayerWriteBlockedWordEvent;
import de.morigm.magna.api.listner.Listener;
import de.morigm.magna.chat.Chat;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BlackList extends Listener {

    @EventHandler
    public void on(AsyncChatEvent e) {
        if (Magna.getBlackListManager().hasBlackWord(e.message().toString())) {
            BlackWord bword = Magna.getBlackListManager().getBlackWordFromText(e.message().toString());
            Bukkit.getPluginManager().callEvent(new PlayerWriteBlockedWordEvent(e.getPlayer(), bword.word(), bword.type()));
            if (!e.getPlayer().hasPermission(bword.permission()) || !Magna.getSettings().getBlackListPermission()) {
                switch (bword.type()) {
                    case NORMAL -> normal(e);
                    case KICK -> kick(e);
                    case WARN -> warn(e);
                    case MUTE -> mute(e);
                    case BAN -> ban(e);
                    case DE_OP -> deop(e);
                    case SPAWN -> spawn(e);
                    case GROUP_KICK -> groupkick(e);
                    case GROUP_BAN -> groupban(e);
                    case KILL -> kill(e);
                    case CLEAR -> clear(e);
                    case BLIND -> blind(e);
                    default -> {
                    }
                }
            }
        }
    }

    private void blind(AsyncChatEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void clear(AsyncChatEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getPlayer().getInventory().clear();
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void kill(AsyncChatEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getPlayer().setHealth(0);
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void groupban(AsyncChatEvent e) {
        new BukkitRunnable() {

            @Override
            public void run() {
                if (Magna.getGroupManager().isPlayerInGroup(e.getPlayer()))
                    for (Player t : Magna.getGroupManager()
                            .getPlayersByGroup(Main.getInstance().getGroupManager().getGroupFromPlayer(e.getPlayer())))
                        t.getPlayer().kickPlayer("Banned Word");
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void groupkick(AsyncChatEvent e) {
        new BukkitRunnable() {

            @Override
            public void run() {
                if (Magna.getGroupManager().isPlayerInGroup(e.getPlayer()))
                    for (Player t : Magna.getGroupManager().getPlayersByGroup(
                            Main.getInstance().getGroupManager().getGroupFromPlayer(e.getPlayer()))) {
                        Bukkit.getBanList(Type.NAME).addBan(t.getName(), "You are not allowed to write this text", null,
                                "Magna");
                        t.getPlayer().kickPlayer("Banned Word");
                    }
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void spawn(AsyncChatEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Main.getInstance().getDefaultPluginConfig().spawn != null)
                    e.getPlayer().teleport(Main.getInstance().getDefaultPluginConfig().spawn);
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void deop(AsyncChatEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getPlayer().setOp(false);
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void ban(AsyncChatEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getBanList(Type.NAME).addBan(e.getPlayer().getName(), "You are not allowed to write this text",
                        null, "Magna");
                e.getPlayer().kickPlayer("Banned Word");
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void mute(AsyncChatEvent e) {
        Magna.getMutedPlayerManager().addPlayer(e.getPlayer());
        e.setCancelled(true);
    }

    private void warn(AsyncChatEvent e) {
        e.getPlayer().sendMessage(Chat.prefix + translate("listener.censor.warn"));
        e.setCancelled(true);
    }

    private void kick(AsyncChatEvent e) {
        new BukkitRunnable() {

            @Override
            public void run() {
                e.getPlayer().kickPlayer("Banned Word");
            }
        }.runTaskLater(Main.getInstance(), 1);
        e.setCancelled(true);
    }

    private void normal(AsyncChatEvent e) {
        e.setCancelled(true);
    }

}
