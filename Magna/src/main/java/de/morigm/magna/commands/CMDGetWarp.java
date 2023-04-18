package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDGetWarp extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("getwarp");
        util().registerTranslation("cmd.getwarp.error");
        util().registerTranslation("cmd.getwarp.world");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "getwarp")) {
                if (args.length >= 1) {
                    String warpname = args[0];
                    if (Magna.getWarpManager().containsWarp(warpname)) {
                        Location loc = Magna.getWarpManager().getWarpLocation(warpname);
                        p.sendMessage(
                                Chat.prefix + "X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ()
                                        + " " + translate("cmd.getwarp.world") + ":" + loc.getWorld().getName());
                    } else
                        p.sendMessage(Chat.prefix + translate("cmd.getwarp.error"));
                } else
                    p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <warp>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
