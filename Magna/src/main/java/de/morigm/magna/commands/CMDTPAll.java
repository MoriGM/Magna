package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDTPAll extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("tpall");
        util().registerTranslation("cmd.tpall");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "tpall")) {
                for (Player t : Bukkit.getOnlinePlayers())
                    if (t != p)
                        t.teleport(p);
                p.sendMessage(Chat.prefix + translate("cmd.tpall"));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
