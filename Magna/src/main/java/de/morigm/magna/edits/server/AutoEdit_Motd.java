package de.morigm.magna.edits.server;

import org.bukkit.Bukkit;

import de.morigm.magna.api.autoedit.AutoEditStruct;

public class AutoEdit_Motd implements AutoEditStruct {

	@Override
	public String getName() {
		return "[motd]";
	}

	@Override
	public String getEdit() {
		return Bukkit.getMotd();
	}

}
