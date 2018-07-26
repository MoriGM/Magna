package de.morigm.magna.edits.server;

import org.bukkit.Bukkit;

import de.morigm.magna.api.autoedit.AutoEditStruct;

public class AutoEdit_PlayerCount implements AutoEditStruct
{

	@Override
	public String getName() 
	{
		return "[playercount]";
	}

	@Override
	public String getEdit() 
	{
		return String.valueOf(Bukkit.getOnlinePlayers().size());
	}

}
