package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDTpHere extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("tphere");
		util().registerTranslation("cmd.tphere");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player p) {
			if (testPermission(p, "tphere")) {
				if (args.length >= 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null) {
						t.teleport(p);
						p.sendMessage(Chat.prefix + translate("cmd.tphere"));
					} else
						Chat.noOnline(p);
				} else
					p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
			} else
				Chat.noPermission(p);
		} else
			Chat.noConsole(com);
		return false;
	}

}
