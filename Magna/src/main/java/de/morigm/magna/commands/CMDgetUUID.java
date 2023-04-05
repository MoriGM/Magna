package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.chat.Chat;
import lombok.SneakyThrows;
import org.bukkit.command.CommandSender;

public class CMDgetUUID extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("getuuid");
    }

    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (testPermission(com, "getuuid")) {
            if (args.length >= 1) {
                String name = args[0];
                com.sendMessage(Chat.prefix + "UUID:" + MojangApi.getPlayerUUID(name));
            } else
                com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <name>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
