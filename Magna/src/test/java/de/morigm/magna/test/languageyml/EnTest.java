package de.morigm.magna.test.languageyml;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import de.morigm.magna.api.Magna;
import de.morigm.magna.loader.PluginLoader;

public class EnTest 
{
	public class CommandLoader extends PluginLoader
	{
		private boolean isactive = false; 
		
		@Override
		public void registerCommands() 
		{
			if(!isactive)
				super.registerCommands();
			isactive = true;
		}
	}
	
	@Test
	public void testEnYml() throws IOException
	{
		System.out.println("Test En YML");
		CommandLoader loader = new CommandLoader();
		loader.registerCommands();
		List<String> translations = Magna.getCommandUtil().getTranslations();
		Properties prop = new Properties();
		prop.load(ClassLoader.getSystemResourceAsStream("en-en.yml"));
		for(String s : translations)
		{
			System.out.println("Test English Translation: " + s);
			assertTrue(prop.containsKey(s));
		}
	}
}
