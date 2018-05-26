package de.morigm.magna.loader;

import de.morigm.magna.commands.CMD_Fly;
import de.morigm.magna.commands.CMD_GODMODE;
import de.morigm.magna.commands.CMD_IP;
import de.morigm.magna.commands.CMD_ItemHead;
import de.morigm.magna.commands.CMD_MUTED;
import de.morigm.magna.commands.CMD_ReloadConfig;
import de.morigm.magna.commands.CMD_SPY;
import de.morigm.magna.commands.CMD_SetItemName;
import de.morigm.magna.commands.CMD_getworld;
import de.morigm.magna.commands.CMD_heal;
import de.morigm.magna.commands.CMD_tpall;
import de.morigm.magna.listener.Listener_CMDSPY;
import de.morigm.magna.listener.Listener_GODMODE;
import de.morigm.magna.listener.Listener_Muted;

public class PluginLoader 
{

	public void registerCommands()
	{
		new CMD_Fly().register("fly");
		new CMD_GODMODE().register("godmode");
		new CMD_MUTED().register("mute");
		new CMD_heal().register("heal");
		new CMD_getworld().register("getworld");
		new CMD_SetItemName().register("setitemname");
		new CMD_IP().register("ip");
		new CMD_tpall().register("tpall");
		new CMD_ItemHead().register("itemhead");
		new CMD_SPY().register("cmdspy");
		new CMD_ReloadConfig().register("reloadconfig");
	}
	
	public void registerListener()
	{
		new Listener_GODMODE().register();
		new Listener_Muted().register();
		new Listener_CMDSPY().register();
	}
	
}
