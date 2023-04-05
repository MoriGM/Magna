package de.morigm.magnaworld.api.helper;

import org.bukkit.World.Environment;
import org.bukkit.WorldType;

public class EnumHelper {

	public static boolean isWorldType(String s) {
		for (WorldType w : WorldType.values())
			if (w.name().equals(s))
				return true;
		return false;
	}

	public static boolean isEnvironment(String s) {
		for (Environment e : Environment.values())
			if (e.name().equals(s))
				return true;
		return false;
	}

}
