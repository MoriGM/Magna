package de.morigm.magna.listener;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.events.PlayerWriteBlockedWordEvent;
import de.morigm.magna.api.helper.ListenerHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BlackList extends ListenerHelper {

	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		if (Magna.getBlackListManager().hasBlackWord(e.getMessage())) {
			BlackWord bword = Magna.getBlackListManager().getBlackWordFromText(e.getMessage());
			Bukkit.getPluginManager().callEvent(new PlayerWriteBlockedWordEvent(e.getPlayer(), bword.word(), bword.type()));
			if (!e.getPlayer().hasPermission(bword.permission()) || !Magna.getSettings().getBlackListPermission()) {
				switch (bword.type()) {
					case NORMAL -> normal(e);
					case KICK -> kick(e);
					case WARN -> warn(e);
					case MUTE -> mute(e);
					case BAN -> ban(e);
					case DEOP -> deop(e);
					case SPAWN -> spawn(e);
					case GROUPKICK -> groupkick(e);
					case GROUPBAN -> groupban(e);
					case KILL -> kill(e);
					case CLEAR -> clear(e);
					case BLIND -> blind(e);
					default -> {
					}
				}
			}
		}
	}

	private void blind(AsyncPlayerChatEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void clear(AsyncPlayerChatEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				e.getPlayer().getInventory().clear();
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void kill(AsyncPlayerChatEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				e.getPlayer().setHealth(0);
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void groupban(AsyncPlayerChatEvent e) {
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

	private void groupkick(AsyncPlayerChatEvent e) {
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

	private void spawn(AsyncPlayerChatEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (Main.getInstance().getDefaultPluginConfig().spawn != null)
					e.getPlayer().teleport(Main.getInstance().getDefaultPluginConfig().spawn);
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void deop(AsyncPlayerChatEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				e.getPlayer().setOp(false);
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void ban(AsyncPlayerChatEvent e) {
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

	private void mute(AsyncPlayerChatEvent e) {
		Magna.getMutedPlayerManager().addPlayer(e.getPlayer());
		e.setCancelled(true);
	}

	private void warn(AsyncPlayerChatEvent e) {
		e.getPlayer().sendMessage(Chat.prefix + translate("listener.censor.warn"));
		e.setCancelled(true);
	}

	private void kick(AsyncPlayerChatEvent e) {
		new BukkitRunnable() {

			@Override
			public void run() {
				e.getPlayer().kickPlayer("Banned Word");
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void normal(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
	}

}
