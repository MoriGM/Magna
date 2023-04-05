package de.morigm.magna.edits.player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import org.bukkit.entity.Player;

public class AutoEdit_WorldPlayerCount implements PlayerAutoEditStruct {

	@Override
	public String getName() {
		return "[playerworldcount]";
	}

	@Override
	public String getEdit(Player p) {
		return String.valueOf(p.getWorld().getPlayers().size());
	}

}
