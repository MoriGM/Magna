package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.warp.Warp;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getWarpManager;

public class CMDWarps extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("warps");
        util().registerTranslation("cmd.warps");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "warps")) {
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
