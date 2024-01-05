package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import org.bukkit.entity.Player;

import java.util.List;

public class GodModeManager {
    public void addPlayer(Player p) {
        if (!getPlayers().contains(p.getUniqueId().toString()))
            getPlayers().add(p.getUniqueId().toString());
    }

    public void removePlayer(Player p) {
        getPlayers().remove(p.getUniqueId().toString());
    }

    public boolean containsPlayer(Player p) {
        return getPlayers().contains(p.getUniqueId().toString());
    }

    public void togglePlayer(Player p) {
        if (this.containsPlayer(p))
            this.removePlayer(p);
        else
            this.addPlayer(p);
    }

    public List<String> getPlayers() {
        return Main.Companion.getInstance().getPlayerConfig().godmode;
    }

}
