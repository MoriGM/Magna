package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;

public class CMDChatClear extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("chatclear");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (testPermission(com, "chatclear"))
            for (int i = 0; i < 100; i++)
                com.sendMessage(" ");
        else
            Chat.noPermission(com);
        return false;
    }

}
