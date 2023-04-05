package de.morigm.magna.commands;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDFly extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("fly");
		util().registerTranslation("cmd.fly.you.on");
		util().registerTranslation("cmd.fly.player.on");
		util().registerTranslation("cmd.fly.you.off");
		util().registerTranslation("cmd.fly.player.off");
	}

	@Override
	public boolean onCommand(CommandSender com, Command command, String label, String[] args) {
		if (com instanceof Player t) {
			if (testPermission(t, "fly")) {
				if (args.length >= 1)
					t = Bukkit.getPlayer(args[0]);
				if (t != null) {
					t.setAllowFlight(!t.getAllowFlight());
					com.sendMessage(Chat.prefix + (t.getAllowFlight()
							? ChatColor.GREEN
							+ (com == t ? translate("cmd.fly.you.on") : translate("cmd.fly.player.on"))
							: ChatColor.RED
							+ (com == t ? translate("cmd.fly.you.off") : translate("cmd.fly.player.off"))));
				} else
					Chat.noOnline(com);
			} else
				Chat.noPermission(com);
		} else
			Chat.noConsole(com);
		return false;
	}

}
