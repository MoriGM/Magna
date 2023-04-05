package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDAFK extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player p) {
			Magna.getAFKManager().togglePlayer(p);
		} else
			Chat.noConsole(com);
		return false;
	}

}
