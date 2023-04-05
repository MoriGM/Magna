package de.morigm.magnaworld.api.world;

import org.bukkit.World;

import lombok.Getter;

public class WorldStruct {

	@Getter
	private String name;
	@Getter
	private World world;
	@Getter
	private Long seed = null;

	public WorldStruct(String name) {
		if (name.contains(".."))
			throw new NullPointerException("Name is not allowed");
		this.name = name;
	}

	public WorldStruct(String name, Long seed) {
		this(name);
		this.seed = seed;
	}

	public void load(World world) {
		if (this.world != null)
			throw new RuntimeException("Allready loaded");
		this.world = world;
		this.seed = world.getSeed();
	}

}
