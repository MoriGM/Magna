package de.morigm.magna.api.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import lombok.SneakyThrows;

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
	
	@SneakyThrows
	public static void copy(File in,File out)
	{
		FileInputStream ins = new FileInputStream(in);
		FileOutputStream outs = new FileOutputStream(out);
		copyFile(ins, outs);
		ins.close();
		outs.close();
	}
	
	@SneakyThrows
	public static void copy(InputStream in,File out)
	{
		FileOutputStream outs = new FileOutputStream(out);
		copyFile(in, outs);
		outs.close();
	}
	
	@SneakyThrows
	public static void copy(File in,OutputStream out)
	{
		FileInputStream ins = new FileInputStream(in);
		copyFile(ins, out);
		ins.close();
	}
	
	@SneakyThrows
	public static void copyFile(InputStream in,OutputStream out)
	{
		IOUtils.copy(in, out);
	}
	
	public static void getFiles(List<File> files,File folder)
	{
		for(File f : folder.listFiles())
			if(f.isDirectory())
				getFiles(files, f);
			else
			{
				files.add(f);
			}
				
		files.add(folder);
	}
	
	public static void delete(List<File> files)
	{
		List<File> folders = new ArrayList<>();
		for(File f : files)
			if(f.exists())
				if(f.isDirectory())
					folders.add(f);
				else
					f.delete();
		
		for(File f : folders)
			if(f.exists())
				f.delete();
	}
	
}
