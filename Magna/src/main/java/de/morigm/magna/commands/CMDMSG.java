package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getMSGManager;

public class CMDMSG extends CommandHelper {
	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerTranslation("cmd.msg.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player p) {
			if (args.length >= 2) {
				Player t = Bukkit.getPlayer(args[0]);
				String text = StringHelper.StringArrayToString(args, " ", 1).replace('&', '§');
				if (t != null) {
					if (t != p) {
						t.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " -> "
								+ ChatColor.BLUE + t.getName() + ChatColor.GRAY + "]" + ChatColor.RESET + " " + text);
						getMSGManager().updateMSG(p, t);
					} else
						p.sendMessage(Chat.prefix + translate("cmd.msg.error"));
				} else
					Chat.noOnline(p);
			} else
				p.sendMessage(Chat.prefix + "/" + getCommand() + " <Player> <MSG>");
		} else
			Chat.noConsole(com);

		return false;
	}

}
