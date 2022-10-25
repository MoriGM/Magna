package de.morigm.magna.commands;

import static de.morigm.magna.api.Magna.getWarpManager;

import de.morigm.magna.api.warp.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;
import org.jetbrains.annotations.NotNull;

public class CMDWarps extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("warps");
		util().registerTranslation("cmd.warps");
	}

	@Override
	public boolean onCommand(@NotNull CommandSender com, @NotNull Command cmd, @NotNull String label,
			@NotNull String[] args) {
		if (com instanceof Player p) {
			if (testPermission(p, "warps")) {
				StringBuilder warps = new StringBuilder();
				for (Warp w : getWarpManager().getWarps())
					if (warps.length() == 0)
						warps.append(w.name);
					else
						warps.append(",").append(w.name);
				p.sendMessage(Chat.prefix + translate("cmd.warps") + ":" + warps);
			} else
				Chat.noPermission(p);
		} else
			Chat.noConsole(com);
		return false;
	}
}
