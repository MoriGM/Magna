package de.morigm.magna.api.helper;

import de.morigm.magna.Main;

public interface TranslationHelper
{

	public default String translate(String text)
	{
		return Main.getInstance().getLanguage().translate(text);
	}
	
}
