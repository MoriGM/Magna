package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDOpenWorkbench extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("workbench");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player p) {
			if (testPermission(com, "workbench"))
				p.openWorkbench(p.getLocation(), true);
			else
				Chat.noPermission(p);
		} else
			Chat.noConsole(com);
		return false;
	}

}
