package de.morigm.magna.loader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.LoadHelper;

public class LanguageLoader implements LoadHelper
{
	private File language;
	
	public void installDe(File de)
	{
		try 
		{
			FileOutputStream out = new FileOutputStream(de);
			IOUtils.copy(Main.getInstance().getResource("de-de.yml"), out);
			out.close();
		}
		catch (IOException e) 
		{e.printStackTrace();}
		
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
		{e.printStackTrace();}
	}
	
	
	public void update(File file,String data)
	{
		Map<String,String> map = new HashMap<>();
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(file));
			while(reader.ready())
			{
				String[] args = reader.readLine().split("=");
				String s = "";
				for(int i = 1;i < args.length;i++)
					s += args[i] + "=";
				s = s.substring(0,s.length() - 1);
				map.put(args[0], s);
			}
			reader.close();
		}
		catch (IOException e) 
		{e.printStackTrace();}
		try 
		{
			reader = new BufferedReader(new InputStreamReader(Main.getInstance().getResource(data)));
			while(reader.ready())
			{
				String[] args = reader.readLine().split("=");
				String s = "";
				for(int i = 1;i < args.length;i++)
					s += args[i] + "=";
				s = s.substring(0,s.length() - 1);
				if(!map.containsKey(args[0]))
					map.put(args[0], s);
			}
			reader.close();
		}
		catch (IOException e) 
		{e.printStackTrace();}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(Entry<String,String> set : map.entrySet())
			{
				writer.write(set.getKey() + "=" + set.getValue());
				writer.newLine();
			}
			writer.close();
		} 
		catch (IOException e) 
		{e.printStackTrace();}
	}
	
	public void check()
	{
		File de = new File(Magna.getFolders().getLanguageFolder(), "de-de.yml");
		File en = new File(Magna.getFolders().getLanguageFolder(), "en-en.yml");
		
		if(!de.exists())
			installDe(de);
		if(!en.exists())
			installEn(en);
		
		if(de.lastModified() < Main.getInstance().getJar().lastModified())
			update(de,"de-de.yml");
		if(en.lastModified() < Main.getInstance().getJar().lastModified())
			update(en,"en-en.yml");
		
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
