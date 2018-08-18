package de.morigm.magna.api.settings;

import java.io.File;

import de.morigm.magna.api.Magna;
import lombok.Getter;

public class Folders 
{
	
	@Getter private File languageFile;
	@Getter private File autoEditFile;
	@Getter private File playerAutoEditFile;
	@Getter private File blackListFile;
	@Getter private File deathBackFile;
	@Getter private File groupsFile;
	@Getter private File playerFile;
	@Getter private File warpsFile;
	@Getter private File homeFile;
	@Getter private File pluginFolder;
	@Getter private File dataFolder;
	@Getter private File languageFolder;
	
	

	public Folders() 
	{
		this.pluginFolder = new File("plugins");
		this.dataFolder = new File(this.pluginFolder,Magna.getName());
		this.languageFolder = new File(dataFolder,"languages");
		this.languageFile = new File(this.languageFolder,Magna.getSettings().getLanguage());
		this.autoEditFile = new File(this.dataFolder, "autoedit.yml");
		this.playerAutoEditFile = new File(this.dataFolder, "playerautoedit.yml");
		this.blackListFile = new File(this.dataFolder,"blacklist.yml");
		this.deathBackFile = new File(this.dataFolder,"deathback.yml");
		this.groupsFile = new File(this.dataFolder,"groups.yml");
		this.playerFile = new File(this.dataFolder,"players.yml");
		this.warpsFile = new File(this.dataFolder,"warps.yml");
		this.homeFile = new File(this.dataFolder,"homes.yml");
	}
	
}
