package de.morigm.magna.api.language;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import de.morigm.magna.api.helper.LoadHelper;
import lombok.Getter;

public class Language implements LoadHelper
{
	
	private Properties prop;
	@Getter private File languageFile;
	
	public Language(File file) 
	{
		this.languageFile = file;
	}
	
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
			prop.load(new FileInputStream(this.languageFile));
		}
		catch (IOException e) {e.printStackTrace();}
	}

}
