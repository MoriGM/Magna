package de.morigm.magna.api.deathback;

import org.bukkit.Location;

public class DeathBack {

	public DeathBack(String uuid, Location location) {
		this.uuid = uuid;
		this.location = location;
	}

	public Location location;
	public final String uuid;
}
