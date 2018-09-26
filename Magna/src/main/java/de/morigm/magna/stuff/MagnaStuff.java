package de.morigm.magna.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import de.morigm.magna.api.gui.Gui;
import lombok.Getter;

public class MagnaStuff 
{
	static
	{
		msg = new HashMap<>();
		onlybreaks = new ArrayList<>();
	}
	
	
	@Getter private static Map<String,String> msg;
	@Getter private static List<Player> onlybreaks;
	@Getter private static Map<Player,Gui> guis = new HashMap<>();
}
