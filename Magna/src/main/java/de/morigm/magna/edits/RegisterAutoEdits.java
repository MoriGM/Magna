package de.morigm.magna.edits;

import de.morigm.magna.api.autoedit.AutoEditStruct;
import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import de.morigm.magna.edits.player.*;
import de.morigm.magna.edits.server.AutoEdit_Motd;
import de.morigm.magna.edits.server.AutoEdit_PlayerCount;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class RegisterAutoEdits {

    @Getter
    final
    List<PlayerAutoEditStruct> playerAutoEditStructs = new ArrayList<>();
    @Getter
    final
    List<AutoEditStruct> autoEditStructs = new ArrayList<>();

    public void registerServerStruct() {
        new AutoEdit_PlayerCount().register();
        new AutoEdit_Motd().register();
    }

    public void registerPlayerStruct() {
        new AutoEdit_WorldName().register();
        new AutoEdit_PlayerName().register();
        new AutoEdit_PlayerUUID().register();
        new AutoEdit_WorldPlayerCount().register();
        new AutoEdit_Item().register();
        new AutoEdit_ItemCount().register();
    }

}
