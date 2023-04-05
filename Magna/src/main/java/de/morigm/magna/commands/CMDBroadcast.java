package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CMDBroadcast extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("broadcast");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command command, String label, String[] args) {
        if (testPermission(com, "broadcast")) {
            if (args.length >= 1) {
                String s = StringHelper.StringArrayToString(args, " ").replace('&', ChatColor.COLOR_CHAR);
                Bukkit.broadcastMessage(s);
            } else
                com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <message>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
