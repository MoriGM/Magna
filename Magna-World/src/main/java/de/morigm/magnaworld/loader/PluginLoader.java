package de.morigm.magnaworld.loader;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magnaworld.Main;
import de.morigm.magnaworld.commands.*;

public class PluginLoader {

	public void register(CommandHelper ch, String command_name) {
		ch.register(command_name, Main.getInstance().getLanguage(), Main.getInstance().getPermission(),
				Main.getInstance());
	}

	public void loadCommands() {
		register(new MWCREATE(), "mwcreate");
		register(new MWTP(), "mwtp");
		register(new MWDELETE(), "mwdelete");
		register(new MWLIST(), "mwlist");
		register(new MWIMPORT(), "mwimport");
	}

	public void loadListener() {

	}

}
