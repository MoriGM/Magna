package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDChatClear extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("chatclear");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "chatclear"))
            for (int i = 0; i < 100; i++)
                com.sendPlainMessage(" ");
        else
            Chat.noPermission(com);
        return false;
    }

}
