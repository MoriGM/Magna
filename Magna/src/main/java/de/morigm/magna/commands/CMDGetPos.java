package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDGetPos extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("getpos");
        util().registerTranslation("cmd.getpos.world");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(com, "getpos"))
                if (args.length >= 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if (t != null)
                        p.sendMessage(Chat.prefix + "X:" + t.getLocation().getBlockX() + " Y:"
                                + t.getLocation().getBlockY() + " Z:" + t.getLocation().getBlockZ() + " "
                                + translate("cmd.getpos.world") + ":" + t.getLocation().getWorld().getName());
                    else
                        p.sendMessage(Chat.prefix + Chat.no_online);
                } else
                    p.sendMessage(Chat.prefix + "X:" + p.getLocation().getBlockX() + " Y:" + p.getLocation().getBlockY()
                            + " Z:" + p.getLocation().getBlockZ() + " " + translate("cmd.getpos.world") + ":"
                            + p.getLocation().getWorld().getName());
            else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
