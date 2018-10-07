package de.morigm.magnaworld.loader;

import de.morigm.magnaworld.Main;
import de.morigm.magnaworld.commands.MWCREATE;
import de.morigm.magnaworld.commands.MWDELETE;
import de.morigm.magnaworld.commands.MWTP;

public class PluginLoader 
{
	
	public void loadCommands()
	{
		new MWCREATE().register("mwcreate", Main.getInstance().getLanguage(), Main.getInstance().getPermission(),Main.getInstance());
		new MWTP().register("mwtp", Main.getInstance().getLanguage(), Main.getInstance().getPermission(),Main.getInstance());
		new MWDELETE().register("mwdelete", Main.getInstance().getLanguage(), Main.getInstance().getPermission(),Main.getInstance());
}
	
	public void loadListener() 
	{
		
	}

}
