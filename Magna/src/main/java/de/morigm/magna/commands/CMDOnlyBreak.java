package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getOnlyBreakManager;

public class CMDOnlyBreak extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("onlybreak");
		util().registerTranslation("cmd.onlybreak.on");
		util().registerTranslation("cmd.onlybreak.off");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (PlayerHelper.isPlayer(com)) {
			if (testPermission(com, "onlybreak")) {
				Player p = (Player) com;
				getOnlyBreakManager().togglePlayer(p);
				if (getOnlyBreakManager().containsPlayer(p))
					p.sendMessage(Chat.prefix + translate("cmd.onlybreak.on"));
				else
					p.sendMessage(Chat.prefix + translate("cmd.onlybreak.off"));
			} else
				Chat.noPermission(com);
		} else
			Chat.noConsole(com);
		return false;
	}

}
