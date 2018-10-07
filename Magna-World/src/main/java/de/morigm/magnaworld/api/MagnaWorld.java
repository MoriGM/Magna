package de.morigm.magnaworld.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

import de.morigm.magnaworld.api.world.WorldStruct;
import lombok.NonNull;

public class MagnaWorld 
{
	
	private static List<WorldStruct> worlds = new ArrayList<>();
	
	public static void registerWorld(@NonNull WorldStruct world,@NonNull WorldType type,@NonNull Environment ev)
	{
		if(!containsWorld(world) && !containsWorld(world.getName()))
		{
			WorldCreator creator = new WorldCreator(world.getName());
			if(world.getSeed() != null)
				creator.seed(world.getSeed());
			creator.environment(ev);
			creator.type(type);
			World w = Bukkit.createWorld(creator);
			world.load(w);
			getWorlds().add(world);
		}
	}
	
	public static void loadWorld(@NonNull WorldStruct world)
	{
		if(!containsWorld(world) && !containsWorld(world.getName()))
		{
			WorldCreator creator = new WorldCreator(world.getName());
			World w = Bukkit.createWorld(creator);
			world.load(w);
			getWorlds().add(world);
		}
	}
	
	public static List<WorldStruct> getWorlds()
	{
		return MagnaWorld.worlds;
	}
	
	public static WorldStruct getWorld(String world)
	{
		for(WorldStruct w : getWorlds())
			if(w.getName().equals(world))
				return w;
		return null;
	}
	
	public static boolean containsWorld(WorldStruct world)
	{
		return getWorlds().contains(world);
	}
	
	public static boolean containsWorld(String world)
	{
		return getWorld(world) != null;
	}
	
	public static void removeWorld(String name)
	{
		if(containsWorld(name))
			getWorlds().remove(getWorld(name));
	}

	public static String getName() 
	{
		return "MagnaWorld";
	}
	
}
