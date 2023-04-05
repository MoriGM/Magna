package de.morigm.magna.edits.player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import org.bukkit.entity.Player;

public class AutoEdit_WorldName implements PlayerAutoEditStruct {

    @Override
    public String getName() {
        return "[world]";
    }

    @Override
    public String getEdit(Player p) {
        return p.getWorld().getName();
    }

}
