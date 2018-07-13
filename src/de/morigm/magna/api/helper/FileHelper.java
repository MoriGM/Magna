package de.morigm.magna.api.helper;

import java.io.File;
import java.io.IOException;

public class FileHelper
{
	
	public static void createFileIfNotExists(String file)
	{
		createFileIfNotExists(new File(file));
	}
	
	public static void createFileIfNotExists(File file)
	{
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void createFile(String file)
	{
		createFile(new File(file));
	}
	
	public static void createFile(File file)
	{
		try 
		{
			file.createNewFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
