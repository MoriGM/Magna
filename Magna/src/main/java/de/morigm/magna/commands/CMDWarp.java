package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getWarpManager;

public class CMDWarp extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("warp");
        util().registerTranslation("cmd.warp");
        util().registerTranslation("cmd.warp.error");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "warp")) {
                if (args.length >= 1) {
                    String warpname = args[0];
                    if (getWarpManager().containsWarp(warpname)) {
                        if (p.hasPermission(getWarpManager().getWarp(warpname).permission)) {
                            p.teleport(getWarpManager().getWarpLocation(warpname));
                            p.sendMessage(Chat.prefix + translate("cmd.warp") + " " + warpname);
                        }
                    } else
                        p.sendMessage(Chat.prefix + translate("cmd.warp.error"));
                } else
                    p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <warp>");
            } else
                Chat.noPermission(com);
        } else
            Chat.noConsole(com);
        return false;
    }

}
