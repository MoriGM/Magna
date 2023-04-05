package de.morigm.magnaworld.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class MWLIST extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("mwlist");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (testPermission(sender, "mwlist")) {
			String worlds = "";
			for (World w : Bukkit.getWorlds())
				worlds += w.getName() + ",";

			worlds = worlds.substring(0, worlds.length() - 1);

			sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + "Worlds:" + worlds);
		} else
			Chat.noPermission(sender);
		return false;
	}

}
