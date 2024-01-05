package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import de.morigm.magna.api.waypoint.WayPoint;
import de.morigm.magna.loader.WayPointLoader;
import org.bukkit.Location;

import java.util.List;

public class WayPointManager {

    public void SetWayPoint(String name, String uuid, Location loc) {
        WayPoint w = new WayPoint(name, uuid, Main.Companion.getInstance().getPermissionManager().getPermission("waypoint"), loc);
        if (!ContainsWayPoint(w.Name, w.UUID)) {
            GetWayPoints().add(w);
        }
    }

    public void RemoveWarp(String name, String uuid) {
        if (ContainsWayPoint(name, uuid)) {
            GetWayPoints().remove(GetWayPoint(name, uuid));
        }
    }

    public Location GetWarpLocation(String name, String uuid) {
        return ContainsWayPoint(name, uuid) ? GetWayPoint(name, uuid).Location : null;
    }

    public WayPoint GetWayPoint(String name, String uuid) {
        for (WayPoint w : GetWayPoints()) {
            if (w.Name.equals(name) && w.UUID.equals(uuid)) {
                return w;
            }
        }
        return null;
    }

    public boolean ContainsWayPoint(String name, String uuid) {
        return GetWayPoint(name, uuid) != null;
    }

    public List<WayPoint> GetWayPoints() {
        return GetWayPointLoader().getWayPoints();
    }

    private WayPointLoader GetWayPointLoader() {
        return Main.Companion.getInstance().getWayPointLoader();
    }
}
