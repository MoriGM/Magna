package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CMDBans extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("bans");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (testPermission(com, "bans")) {
			String bans = "";
			BanList list = Bukkit.getBanList(Type.NAME);
			for (BanEntry ban : list.getBanEntries())
				bans += ban.getTarget() + " ";
			com.sendMessage("Bans:" + bans);
		} else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
