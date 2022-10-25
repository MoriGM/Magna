package de.morigm.magna.api.helper;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.language.TextStruct;

public interface TranslationHelper {

	public default String translate(String text, TextStruct... structs) {
		return Magna.getLanguage().translate(text, structs);
	}

}
