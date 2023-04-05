package de.morigm.magna.edits.player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import org.bukkit.entity.Player;

public class AutoEdit_Item implements PlayerAutoEditStruct {

	@Override
	public String getName() {
		return "[item]";
	}

	@Override
	public String getEdit(Player p) {
        return p.getInventory().getItemInMainHand().getType().name().replace('_', ' ').toLowerCase();
	}

}
