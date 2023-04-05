package de.morigm.magna.api.waypoint;

import org.bukkit.Location;

public class WayPoint {

    public final String Name;
    public final String Permission;
    public final String UUID;
    public final Location Location;

    public WayPoint(String name, String uuid, String Permission, Location location) {
        this.Name = name;
        this.UUID = uuid;
        this.Permission = Permission;
        this.Location = location;
    }

}
