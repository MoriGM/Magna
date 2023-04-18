package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getWarpManager;

public class CMDRemoveWarp extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("removewarp");
        util().registerTranslation("cmd.removewarp");
        util().registerTranslation("cmd.removewarp.error");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "removewarp")) {
                if (args.length >= 1) {
                    String warpname = args[0];
                    if (getWarpManager().containsWarp(warpname)) {
                        getWarpManager().removeWarp(warpname);
                        p.sendMessage(Chat.prefix + translate("cmd.removewarp"));
                    } else
                        p.sendMessage(Chat.prefix + translate("cmd.removewarp.error"));
                } else
                    p.sendMessage(Chat.prefix + "/" + getCommand() + " <warp>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
