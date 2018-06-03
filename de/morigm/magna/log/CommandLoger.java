package de.morigm.magna.log;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import de.morigm.magna.api.helper.LogerHelper;
import de.morigm.magna.api.log.Log;

public class CommandLoger implements LogerHelper
{

	private Log log;
	
	@Override
	public void load() 
	{
		LocalDateTime local = LocalDateTime.now();
		File dir = new File("./server-log/command/");
		if(!dir.exists())
			dir.mkdirs();
		try 
		{
			log = new Log(new File(dir, local.getDayOfMonth() + ":" + local.getMonthValue() + ":" + local.getYear() + ":" + local.getHour() + ":"  + local.getMinute() + ".log"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void save() 
	{
		log.save();
	}

	@Override
	public void addLine(String text) 
	{
		log.log(text);
	}

}
