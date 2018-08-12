package de.morigm.magna.api.helper;

import de.morigm.magna.api.Magna;

public interface TranslationHelper
{

	public default String translate(String text)
	{
		return Magna.getLanguage().translate(text);
	}
	
}
