package de.morigm.magna.edits.server;

import de.morigm.magna.api.autoedit.AutoEditStruct;
import org.bukkit.Bukkit;

public class AutoEdit_PlayerCount implements AutoEditStruct {

	@Override
	public String getName() {
		return "[playercount]";
	}

	@Override
	public String getEdit() {
		return String.valueOf(Bukkit.getOnlinePlayers().size());
	}

}
