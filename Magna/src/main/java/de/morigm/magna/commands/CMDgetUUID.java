package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.chat.Chat;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDgetUUID extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("getuuid");
    }

    @SneakyThrows
    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "getuuid")) {
            if (args.length >= 1) {
                String name = args[0];
                com.sendPlainMessage(Chat.prefix + "UUID:" + MojangApi.getPlayerUUID(name));
            } else
                com.sendPlainMessage(Chat.prefix + Slash(com) + getCommand() + " <name>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
