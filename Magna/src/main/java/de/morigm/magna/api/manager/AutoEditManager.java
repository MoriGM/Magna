package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import de.morigm.magna.api.autoedit.AutoEditStruct;
import de.morigm.magna.api.autoedit.CustomAutoEditStruct;
import de.morigm.magna.api.autoedit.CustomPlayerAutoEditStruct;
import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import org.bukkit.entity.Player;

import java.util.List;

public class AutoEditManager {

    public String getChangesFromEdit(String text) {
        String edittext = text;
        if (text.contains("[") && text.contains("]")) {
            for (CustomAutoEditStruct s : getCustomAutoEditStructs())
                edittext = edittext.replace(s.name(), s.edit());
            for (AutoEditStruct s : getAutoEditStructs())
                edittext = edittext.replace(s.getName(), s.getEdit());
        }
        return edittext;
    }

    public String getChangesFromEdit(String text, Player p) {
        String edittext = text;
        if (text.contains("[") && text.contains("]")) {
            for (CustomPlayerAutoEditStruct s : getCustomPlayerAutoEditStructs())
                if (s.uuid().equals(p.getUniqueId().toString()))
                    edittext = edittext.replace(s.name(), s.edit());

            for (CustomAutoEditStruct s : getCustomAutoEditStructs())
                edittext = edittext.replace(s.name(), s.edit());

            for (PlayerAutoEditStruct s : getPlayerAutoEditStructs())
                edittext = edittext.replace(s.getName(), s.getEdit(p));

            for (AutoEditStruct s : getAutoEditStructs())
                edittext = edittext.replace(s.getName(), s.getEdit());
        }
        return edittext;
    }

    public List<PlayerAutoEditStruct> getPlayerAutoEditStructs() {
        return Main.Companion.getInstance().getRegisterAutoEdits().getPlayerAutoEditStructs();
    }

    public List<AutoEditStruct> getAutoEditStructs() {
        return Main.Companion.getInstance().getRegisterAutoEdits().getAutoEditStructs();
    }

    public List<CustomAutoEditStruct> getCustomAutoEditStructs() {
        return Main.Companion.getInstance().getAutoEditLoader().getCustomAutoEditStructs();
    }

    public List<CustomPlayerAutoEditStruct> getCustomPlayerAutoEditStructs() {
        return Main.Companion.getInstance().getAutoEditLoader().getCustomPlayerAutoEditStructs();
    }

}
