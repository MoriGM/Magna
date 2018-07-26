package de.morigm.magna.edits.player;

import org.bukkit.entity.Player;

import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;

public class AutoEdit_WorldPlayerCount implements PlayerAutoEditStruct 
{

	@Override
	public String getName()
	{
		return "[playerworldcount]";
	}

	@Override
	public String getEdit(Player p)
	{
		return String.valueOf(p.getWorld().getPlayers().size());
	}

}
