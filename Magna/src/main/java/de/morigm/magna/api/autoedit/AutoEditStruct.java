package de.morigm.magna.api.autoedit;

import de.morigm.magna.Main;

public interface AutoEditStruct {

    String getName();

    String getEdit();

    default void register() {
        Main.Companion.getInstance().getRegisterAutoEdits().getAutoEditStructs().add(this);
    }

}
