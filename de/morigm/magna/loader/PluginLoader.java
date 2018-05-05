package de.morigm.magna.loader;

import de.morigm.magna.commands.CMD_Fly;

public class PluginLoader 
{

	public void registerCommands()
	{
		new CMD_Fly().register("fly");
	}
	
	public void registerListener()
	{
		
	}
	
}
