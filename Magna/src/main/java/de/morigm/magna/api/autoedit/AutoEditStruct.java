package de.morigm.magna.api.autoedit;

import de.morigm.magna.Main;

public interface AutoEditStruct {

    public String getName();

    public String getEdit();

    public default void register() {
        Main.getInstance().getRegisterAutoEdits().getAutoEditStructs().add(this);
    }

}
