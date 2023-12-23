package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import de.morigm.magna.api.deathback.DeathBack;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class DeathBackManager {

    public void setDeathBack(Player p, Location loc) {
        if (hasDeathBack(p)) {
            deleteDeathBack(p);
        }
        DeathBack db = new DeathBack(p.getUniqueId().toString(), loc);
        getDeathBacks().add(db);
    }

    public void deleteDeathBack(Player p) {
        DeathBack db = getDeathBack(p);
        if (db != null)
            getDeathBacks().remove(db);
    }

    public boolean hasDeathBack(Player p) {
        return getDeathBack(p) != null;
    }

    public DeathBack getDeathBack(Player p) {
        for (DeathBack db : getDeathBacks()) {
            if (db.uuid().equals(p.getUniqueId().toString())) {
                return db;
            }
        }
        return null;
    }

    public List<DeathBack> getDeathBacks() {
        return Main.getInstance().getDeathBackLoader().getDeathBacks();
    }

}
