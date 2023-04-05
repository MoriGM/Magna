package de.morigm.magna.stuff;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AFKStuff {

	static {
		last_player_position = new HashMap<>();
		afkPlayers = new ArrayList<>();
		last_player_time = new HashMap<>();
	}

	public static final Map<Player, Location> last_player_position;
	public static final List<Player> afkPlayers;
	public static final Map<Player, Long> last_player_time;

}
