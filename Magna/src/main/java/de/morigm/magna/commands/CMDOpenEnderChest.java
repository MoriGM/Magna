package de.morigm.magna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDOpenEnderChest extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("enderchest");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player) {
			Player p = (Player) com;
			if (p.hasPermission(getPermission("enderchest")))
				p.openInventory(p.getEnderChest());
			else
				Chat.noPermission(p);
		} else
			Chat.noConsole(com);
		return false;
	}

}
