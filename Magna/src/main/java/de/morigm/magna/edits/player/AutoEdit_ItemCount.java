package de.morigm.magna.edits.player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import org.bukkit.entity.Player;

public class AutoEdit_ItemCount implements PlayerAutoEditStruct {

    @Override
    public String getName() {
        return "[itemcount]";
    }

    @Override
    public String getEdit(Player p) {
        return String.valueOf(p.getInventory().getItemInMainHand().getAmount());
    }

}
