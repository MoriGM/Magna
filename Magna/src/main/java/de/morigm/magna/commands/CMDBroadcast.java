package de.morigm.magna.commands;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CMDBroadcast extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("broadcast");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender com, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (checkPermission(com, "broadcast")) {
            if (args.length >= 1) {
                String s = StringHelper.StringArrayToString(args, " ").replace('&', ChatColor.COLOR_CHAR.getColorChar());
                Bukkit.broadcast(Component.text(s));
            } else
                com.sendPlainMessage(Chat.prefix + Slash(com) + getCommand() + " <message>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
