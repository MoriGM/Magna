package de.morigm.magna.edits;

import java.util.ArrayList;
import java.util.List;

import de.morigm.magna.api.autoedit.AutoEditStruct;
import de.morigm.magna.api.autoedit.PlayerAutoEditStruct;
import de.morigm.magna.edits.player.AutoEdit_PlayerName;
import de.morigm.magna.edits.player.AutoEdit_PlayerUUID;
import de.morigm.magna.edits.player.AutoEdit_WorldName;
import de.morigm.magna.edits.player.AutoEdit_WorldPlayerCount;
import de.morigm.magna.edits.server.AutoEdit_Motd;
import de.morigm.magna.edits.server.AutoEdit_PlayerCount;
import lombok.Getter;

public class RegisterAutoEdits
{

	@Getter List<PlayerAutoEditStruct> playerAutoEditStructs = new ArrayList<>();
	@Getter List<AutoEditStruct> autoEditStructs = new ArrayList<>();
	
	public void registerServerStruct()
	{
		new AutoEdit_PlayerCount().register();
		new AutoEdit_Motd().register();
	}

	public void registerPlayerStruct() 
	{
		new AutoEdit_WorldName().register();
		new AutoEdit_PlayerName().register();
		new AutoEdit_PlayerUUID().register();
		new AutoEdit_WorldPlayerCount().register();
	}

}
