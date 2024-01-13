package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import de.morigm.magna.api.group.Group;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupManager {

    public boolean isPlayerInGroup(Player p) {
        return getGroupFromPlayer(p) != null;
    }

    public Group getGroupFromPlayer(Player p) {
        for (Group group : Main.Companion.getInstance().getGroupLoader().getGroups())
            if (p.hasPermission(group.permission))
                return group;
        return null;
    }

    public boolean isPlayerInGroup(Player p, String group_name) {
        return getGroupFromPlayer(p).name.equals(group_name);
    }

    public Group[] getGroups() {
        return Main.Companion.getInstance().getGroupLoader().getGroups();
    }

    public Map<Player, Group> getOnlinePlayerWithGroup() {
        Map<Player, Group> map = new HashMap<>();
        for (Player p : Bukkit.getOnlinePlayers())
            map.put(p, getGroupFromPlayer(p));
        return map;
    }

    public List<Player> getPlayersByGroup(Group group) {
        List<Player> players = new ArrayList<>();
        for (Player t : Bukkit.getOnlinePlayers())
            if (group == getGroupFromPlayer(t) && !players.contains(t))
                players.add(t);
        return players;
    }

    public Group getGroup(String group) {
        for (Group groups : getGroups())
            if (groups.name.equals(group))
                return groups;
        return null;
    }

}
