package de.morigm.magna.loader;

import java.io.File;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.FileHelper;
import de.morigm.magna.api.helper.LanguageFileHelper;
import de.morigm.magna.api.helper.LoadHelper;

public class LanguageLoader implements LoadHelper
{
	
	private File language;
	private String[] languageFiles = {"de-de.yml", "en-en.yml"};

	
	public void check()
	{	
		
		for(String languageFile : languageFiles)
		{
			File file = new File(Magna.getFolders().getLanguageFolder(), languageFile);
			if(!file.exists())
				FileHelper.copy(Main.getInstance().getResource(languageFile), file);
			
			if(file.lastModified() < Main.getInstance().getJar().lastModified())
				LanguageFileHelper.addNewText(Main.getInstance().getResource(languageFile), file);
			
		}
		
		File language = Magna.getFolders().getLanguageFile();
		if(language.exists())
			this.language = language;
		else
			this.language = new File(Magna.getFolders().getLanguageFolder(),"en-en.yml");
	}
	
	public void load()
	{
		if(!Magna.getFolders().getLanguageFolder().exists())
			Magna.getFolders().getLanguageFolder().mkdirs();
		check();
	}
	
	public File getLanguage() 
	{
		return language;
	}
}
