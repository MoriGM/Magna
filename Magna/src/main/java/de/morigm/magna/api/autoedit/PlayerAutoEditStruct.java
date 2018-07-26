package de.morigm.magna.api.autoedit;

import org.bukkit.entity.Player;

import de.morigm.magna.Main;

public interface PlayerAutoEditStruct 
{

	public String getName();
	public String getEdit(Player p);
	
	public default void register()
	{
		Main.getInstance().getRegisterAutoEdits().getPlayerAutoEditStructs().add(this);
	}
	
}
