package de.morigm.magna.api.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class Log 
{
	
		private BufferedWriter writer;
		
		public Log(File f) throws IOException 
		{
			if(!f.exists())
				throw new NullPointerException();
			writer = new BufferedWriter(new FileWriter(f));
		}
		
		public void log(String text)
		{
			LocalTime time = LocalTime.now();
			try 
			{
				writer.write("[LOG]" + time.getSecond() + ":" +  time.getMinute() + ":" + time.getHour() +  ":" + text);
				writer.newLine();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		public void error(String text)
		{
			LocalTime time = LocalTime.now();
			try 
			{
				writer.write("[ERROR]" + time.getSecond() + ":" +  time.getMinute() + ":" + time.getHour() +  ":" + text);
				writer.newLine();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		public void save()
		{
			try 
			{
				writer.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
}
