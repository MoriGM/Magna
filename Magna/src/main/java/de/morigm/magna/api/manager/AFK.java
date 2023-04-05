package de.morigm.magna.api.manager;

import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.TranslationHelper;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.stuff.AFKStuff;

public class AFK implements TranslationHelper {

	public void updateTimeAndLocation(Player p, Location l, long time) {
		getLastPositions().put(p, l);
		getLastPlayerTimes().put(p, time);
	}

	public void updateCurrentPlayer(Player player) {
		getLastPositions().put(player, player.getLocation());
		getLastPlayerTimes().put(player, System.currentTimeMillis());
	}

	public void setLocation(Player p, Location l) {
		getLastPositions().put(p, l);
	}

	public void setTime(Player p, long time) {
		getLastPlayerTimes().put(p, time);
	}

	public Location getLocation(Player p) {
		return getLastPositions().get(p);
	}

	public long getTime(Player p) {
		return getLastPlayerTimes().get(p);
	}

	public boolean containsLocation(Player p) {
		return getLastPositions().containsKey(p);
	}

	public boolean containsTime(Player p) {
		return getLastPlayerTimes().containsKey(p);
	}

	public void addPlayer(Player p) {
		if (!getAFKPlayers().contains(p)) {
			getAFKPlayers().add(p);
			if (Magna.getSettings().getShowAfk())
				Bukkit.broadcastMessage(
						Chat.prefix + translate("afk.show.on", new TextStruct("%player%", p.getName())));
		}
	}

	public void removePlayer(Player p) {
		if (getAFKPlayers().contains(p)) {
			getAFKPlayers().remove(p);
			if (Magna.getSettings().getShowAfk())
				Bukkit.broadcastMessage(
						Chat.prefix + translate("afk.show.off", new TextStruct("%player%", p.getName())));
		}
	}

	public void togglePlayer(Player p) {
		if (isAfk(p)) {
			removePlayer(p);
			return;
		}
		addPlayer(p);
	}

	public boolean isAfk(Player p) {
		return getAFKPlayers().contains(p);
	}

	public List<Player> getAFKPlayers() {
		return AFKStuff.afkPlayers;
	}

	public Map<Player, Location> getLastPositions() {
		return AFKStuff.last_player_position;
	}

	public Map<Player, Long> getLastPlayerTimes() {
		return AFKStuff.last_player_time;
	}
}
