package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDPardon extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("pardon");
        util().registerTranslation("cmd.pardon");
        util().registerTranslation("cmd.pardon.other");

    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "pardon")) {
            if (args.length >= 1) {
                String t = args[0];
                if (Bukkit.getBanList(Type.NAME).isBanned(t)) {
                    Bukkit.getBanList(Type.NAME).pardon(t);
                    com.sendMessage(Chat.prefix + translate("cmd.pardon"));
                } else
                    com.sendMessage(Chat.prefix + translate("cmd.pardon.error"));
            } else
                com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
