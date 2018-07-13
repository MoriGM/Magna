package de.morigm.magna.api.language;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.LoadHelper;

public class Language implements LoadHelper
{
	
	private Properties prop;
	
	public String translate(String text)
	{
		if(prop.containsKey(text))
			return prop.getProperty(text);
		return text;
	}

	@Override
	public void load() 
	{
		prop = new Properties();
		try 
		{
			prop.load(new FileInputStream(Main.getInstance().getLanguageLoader().getLanguage()));
		}
		catch (IOException e) {e.printStackTrace();}
	}

}
