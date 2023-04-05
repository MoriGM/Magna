package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDIP extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("ip");
		util().registerTranslation("cmd.ip");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (testPermission(com, "ip")) {
			if (args.length >= 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if (t != null)
					com.sendMessage(Chat.prefix + translate("cmd.ip", new TextStruct("%player%", t.getName()),
							new TextStruct("%ip%", t.getAddress().getHostString())));
				else
					Chat.noOnline(com);
			} else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
		} else
			Chat.noPermission(com);
		return false;
	}

}
