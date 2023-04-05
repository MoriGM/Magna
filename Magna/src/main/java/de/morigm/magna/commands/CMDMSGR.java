package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDMSGR extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerTranslation("cmd.msgr.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player p) {
			if (args.length >= 1) {
				String target = Magna.getMSGManager().getLastMessagedPlayer(p);
				if (target != null) {
					Player t = Bukkit.getPlayer(target);
					if (t != null) {
						String text = StringHelper.StringArrayToString(args, " ").replace('&', '§');
						t.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " -> "
								+ ChatColor.BLUE + t.getName() + ChatColor.GRAY + "]" + ChatColor.RESET + " " + text);
					} else
						Chat.noOnline(p);
				} else
					p.sendMessage(Chat.prefix + translate("cmd.msgr.error"));
			} else
				p.sendMessage(Chat.prefix + "/" + getCommand() + " <MSG>");
		} else
			Chat.noConsole(com);

		return false;
	}

}
