package de.morigm.magna.loader;

import de.morigm.magna.api.loader.Loader;
import de.morigm.magna.listener.*;

public class Listeners implements Loader {

    @Override
    public void load() {
        new GodMode().register();
        new MutePlayer().register();
        new CommandSpying().register();
        new ChatColor().register();
        new ColorSign().register();
        new LogCommands().register();
        new DeathBack().register();
        new NoFallDamage().register();
        new AutoEdit().register();
        new BlackList().register();
        new AFK().register();
        new SignManipulator().register();
        new OnlyBreak().register();
        new GuiController().register();
    }

}
