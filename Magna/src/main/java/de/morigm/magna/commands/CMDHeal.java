package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDHeal extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("heal");
		util().registerTranslation("cmd.heal.you");
		util().registerTranslation("cmd.heal.player");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player) {
			Player t = (Player) com;
			if (testPermission(com, "heal")) {
				if (args.length >= 1)
					t = Bukkit.getPlayer(args[0]);
				if (t != null) {
					t.setHealth(t.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
					t.setFoodLevel(20);
					com.sendMessage(Chat.prefix
							+ (t == ((Player) com) ? translate("cmd.heal.you") : translate("cmd.heal.player")));
				} else
					Chat.noOnline(com);
			} else
				Chat.noPermission(com);
		} else
			Chat.noConsole(com);
		return false;
	}

}
