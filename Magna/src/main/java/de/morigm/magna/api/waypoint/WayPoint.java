package de.morigm.magna.api.waypoint;

import org.bukkit.Location;

public class WayPoint {

    public String Name, Permission, UUID;
    public Location Location;

    public WayPoint(String name, String uuid,String Permission, Location location) {
        this.Name = name;
        this.UUID = uuid;
        this.Permission = Permission;
        this.Location = location;
    }

}
