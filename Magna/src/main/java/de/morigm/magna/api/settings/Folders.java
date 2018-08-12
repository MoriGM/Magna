package de.morigm.magna.api.settings;

import java.io.File;

import de.morigm.magna.api.Magna;
import lombok.Getter;
import lombok.Setter;

public class Folders 
{
	
	@Getter @Setter private File languageFile;
	@Getter @Setter private File autoEditFile;
	@Getter @Setter private File playerAutoEditFile;
	@Getter @Setter private File blackListFile;
	@Getter @Setter private File deathBackFile;
	@Getter @Setter private File groupsFile;
	@Getter @Setter private File playerFile;
	@Getter @Setter private File warpsFile;
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
		this.warpsFile = new File(this.dataFolder,"/warps.yml");
	}
	
}
