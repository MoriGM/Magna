package de.morigm.magna.api.settings;

import de.morigm.magna.api.Magna;
import lombok.Getter;

import java.io.File;

public class Folders {

    @Getter
    private final File languageFile, autoEditFile, playerAutoEditFile, blackListFile, deathBackFile, groupsFile,
            playerFile, warpsFile, homeFile, pluginFolder, dataFolder, languageFolder, waypointFolder;

    public Folders() {
        this.pluginFolder = new File("plugins");
        this.dataFolder = new File(this.pluginFolder, Magna.getName());
        this.languageFolder = new File(dataFolder, "languages");
        this.languageFile = new File(this.languageFolder, Magna.getSettings().getLanguage());
        this.autoEditFile = new File(this.dataFolder, "autoedit.yml");
        this.playerAutoEditFile = new File(this.dataFolder, "playerautoedit.yml");
        this.blackListFile = new File(this.dataFolder, "blacklist.yml");
        this.deathBackFile = new File(this.dataFolder, "deathback.yml");
        this.groupsFile = new File(this.dataFolder, "groups.yml");
        this.playerFile = new File(this.dataFolder, "players.yml");
        this.warpsFile = new File(this.dataFolder, "warps.yml");
        this.homeFile = new File(this.dataFolder, "homes.yml");
        this.waypointFolder = new File(this.dataFolder, "waypoint.yml");
    }

}
