package de.morigm.magna.edits.server;

import de.morigm.magna.api.autoedit.AutoEditStruct;
import org.bukkit.Bukkit;

public class AutoEdit_Motd implements AutoEditStruct {

    @Override
    public String getName() {
        return "[motd]";
    }

    @Override
    public String getEdit() {
        return Bukkit.getMotd();
    }

}
