package de.morigm.magnaworld.loader;

import de.morigm.magnaworld.Main;
import de.morigm.magnaworld.commands.MWCREATE;

public class PluginLoader 
{
	
	public void loadCommands()
	{
		new MWCREATE().register("mwcreate", Main.getInstance().getLanguage(), Main.getInstance().getPermission(),Main.getInstance());
	}
	
	public void loadListener() 
	{
		
	}

}
