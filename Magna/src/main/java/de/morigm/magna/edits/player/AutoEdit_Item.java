package de.morigm.magna.edits.player;

import org.bukkit.entity.Player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;

public class AutoEdit_Item implements PlayerAutoEditStruct {

	@Override
	public String getName() {
		return "[item]";
	}

	@Override
	public String getEdit(Player p) {
		return String.valueOf(p.getInventory().getItemInMainHand().getType().name().replace('_', ' ').toLowerCase());
	}

}
