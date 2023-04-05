package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.PermissionHelper;
import de.morigm.magna.api.home.Home;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HomeManager implements PermissionHelper {

    private static final int maxHomes = 50;

    public List<Home> getPlayerHomes(Player player) {
        if (getAllHomes().containsKey(player.getUniqueId()))
            return getAllHomes().get(player.getUniqueId());
        else
            return new ArrayList<>();
    }

    public void setHome(Player player, Home home) {
        if (hasHome(player, home.name))
            removeHome(player, home.name);

        if (!hasHome(player, home.name) && getPlayerHomes(player).size() < maxPlayerHomes(player)) {
            List<Home> homes = getPlayerHomes(player);
            homes.add(home);
            getAllHomes().put(player.getUniqueId(), homes);
        }
    }

    public void removeHome(Player player, String name) {
        if (hasHome(player, name)) {
            List<Home> homes = getPlayerHomes(player);
            homes.remove(getHome(player, name));
            getAllHomes().put(player.getUniqueId(), homes);
        }
    }

    public Home getHome(Player player, String name) {
        for (Home home : getPlayerHomes(player))
            if (home.name.equals(name))
                return home;
        return null;
    }

    public boolean hasHome(Player player, String name) {
        return getHome(player, name) != null;
    }

    public int maxPlayerHomes(Player player) {
        if (player.hasPermission(getPermission("homesize") + "." + maxHomes))
            return maxHomes;
        for (int i = 1; i < maxHomes; i++)
            if (player.hasPermission(getPermission("homesize") + "." + i))
                return i;
        return 0;
    }

    public Map<UUID, List<Home>> getAllHomes() {
        return Main.getInstance().getHomeLoader().player_home_map;
    }

}
