package de.morigm.magna.api.language;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.LoadHelper;

public class Language implements LoadHelper
{
	
	public void installDe(File de)
	{
		try 
		{
			FileOutputStream out = new FileOutputStream(de);
			IOUtils.copy(Main.getInstance().getResource("de-de.yml"), out);
			out.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void installEn(File en)
	{
		try 
		{
			FileOutputStream out = new FileOutputStream(en);
			IOUtils.copy(Main.getInstance().getResource("en-en.yml"), out);
			out.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void updateDe(File de)
	{
		
	}
	
	public void updateEn(File en)
	{
		
	}
	
	public void check()
	{
		File de = new File(Main.getInstance().getLanguageFolder(), "de-de.yml");
		File en = new File(Main.getInstance().getLanguageFolder(), "en-en.yml");
		
		if(!de.exists())
			installDe(de);
		if(!en.exists())
			installEn(en);
		
	}
	
	public void load()
	{
		if(!Main.getInstance().getLanguageFolder().exists())
			Main.getInstance().getLanguageFolder().mkdirs();
		check();
	}
	
}
