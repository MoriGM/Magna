package de.morigm.magna.api.manager;

import java.util.List;

import org.bukkit.entity.Player;

import de.morigm.magna.Main;

public class MutedPlayerManager {
	public void addPlayer(Player p) {
		if (!containsPlayer(p))
			getMutedUUIDS().add(p.getUniqueId().toString());
	}

	public void removePlayer(Player p) {
		if (containsPlayer(p))
			getMutedUUIDS().remove(p.getUniqueId().toString());
	}

	public boolean containsPlayer(Player p) {
		return getMutedUUIDS().contains(p.getUniqueId().toString());
	}

	public void togglePlayer(Player p) {
		if (this.containsPlayer(p))
			this.removePlayer(p);
		else
			this.addPlayer(p);
	}

	public List<String> getMutedUUIDS() {
		return Main.getInstance().getPlayerConfig().muted;
	}
}
