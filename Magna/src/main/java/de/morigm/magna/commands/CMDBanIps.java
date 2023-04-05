package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CMDBanIps extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("banips");
	}

	@Override
	public boolean onCommand(@NonNull CommandSender com, @NonNull Command cmd, @NonNull String label, @NonNull String[] args) {
		if (testPermission(com, "banips")) {
			String bans = "";
			BanList list = Bukkit.getBanList(Type.IP);
			for (BanEntry ban : list.getBanEntries())
				bans += ban.getTarget() + " ";
			com.sendMessage("BanIps:" + bans);
		} else
			com.sendMessage(Chat.prefix + Chat.no_permission);
		return false;
	}

}
