package de.morigm.magna.api.settings;

import java.io.File;

import de.morigm.magna.Main;
import lombok.Getter;
import lombok.Setter;

public class Folders 
{
	
	private Main main;
	@Getter @Setter private File languageFile;
	@Getter @Setter private File autoEditFile;
	@Getter @Setter private File playerAutoEditFile;
	@Getter @Setter private File blackListFile;
	@Getter @Setter private File deathBackFile;
	@Getter @Setter private File groupsFile;
	@Getter @Setter private File playerFile;
	@Getter @Setter private File warpsFile;

	public Folders(Main main) 
	{
		this.main = main;
		this.languageFile = new File(this.main.getLanguageFolder(),this.main.getDefaultPluginConfig().language);
		this.autoEditFile = new File(Main.getInstance().getDataFolder(), "autoedit.yml");
		this.playerAutoEditFile = new File(Main.getInstance().getDataFolder(), "playerautoedit.yml");
		this.blackListFile = new File(Main.getInstance().getDataFolder(),"blacklist.yml");
		this.deathBackFile = new File(Main.getInstance().getDataFolder(),"deathback.yml");
		this.groupsFile = new File(Main.getInstance().getDataFolder(),"groups.yml");
		this.playerFile = new File(Main.getInstance().getDataFolder(),"players.yml");
		this.warpsFile = new File(Main.getInstance().getDataFolder(),"/warps.yml");
	}
	
}
