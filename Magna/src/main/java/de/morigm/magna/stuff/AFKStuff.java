package de.morigm.magna.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class AFKStuff
{
	
	static
	{
		last_player_position = new HashMap<>();
		afkPlayers = new ArrayList<>();
	}
	
	public static final Map<Player,Location> last_player_position;
	public static final List<Player> afkPlayers;

}
