package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDTpTo extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("tpto");
        util().registerTranslation("cmd.tpto");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "tpto")) {
                if (args.length >= 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if (t != null) {
                        p.teleport(t);
                        p.sendMessage(Chat.prefix + translate("cmd.tpto") + " " + t.getName());
                    } else
                        Chat.noOnline(p);
                } else
                    p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
