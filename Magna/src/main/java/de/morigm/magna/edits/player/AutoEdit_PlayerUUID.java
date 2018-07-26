package de.morigm.magna.edits.player;

import org.bukkit.entity.Player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;

public class AutoEdit_PlayerUUID implements PlayerAutoEditStruct
{

	@Override
	public String getName()
	{
		return "[uuid]";
	}

	@Override
	public String getEdit(Player p) 
	{
		return p.getUniqueId().toString();
	}

}
