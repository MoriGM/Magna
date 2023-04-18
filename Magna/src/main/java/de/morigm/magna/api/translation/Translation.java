package de.morigm.magna.api.translation;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.TextStruct;

public interface Translation {

    default String translate(String text, TextStruct... structs) {
        return Magna.getLanguage().translate(text, structs);
    }

}
