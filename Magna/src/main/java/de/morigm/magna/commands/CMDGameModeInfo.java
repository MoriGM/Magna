package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDGameModeInfo extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("gamemodeinfo");
		util().registerTranslation("cmd.gamemodeinfo");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (testPermission(com, "gamemodeinfo")) {
			if (args.length >= 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if (t != null)
					com.sendMessage(Chat.prefix + translate("cmd.gamemodeinfo") + ":" + t.getGameMode().name());
				else
					Chat.noOnline(com);
			} else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
		} else
			Chat.noPermission(com);
		return false;
	}

}
