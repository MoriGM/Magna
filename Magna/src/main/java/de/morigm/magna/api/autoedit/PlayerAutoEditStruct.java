package de.morigm.magna.api.autoedit;

import de.morigm.magna.Main;
import org.bukkit.entity.Player;

public interface PlayerAutoEditStruct {

    String getName();

    String getEdit(Player p);

    default void register() {
        Main.getInstance().getRegisterAutoEdits().getPlayerAutoEditStructs().add(this);
    }

}
