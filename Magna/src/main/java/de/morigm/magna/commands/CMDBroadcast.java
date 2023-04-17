package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import de.morigm.magna.api.chat.ChatColor;
import org.bukkit.command.CommandSender;

public class CMDBroadcast extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("broadcast");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command command, String label, String[] args) {
        if (testPermission(com, "broadcast")) {
            if (args.length >= 1) {
                String s = StringHelper.StringArrayToString(args, " ").replace('&', ChatColor.COLOR_CHAR.getColorChar());
                Bukkit.broadcast(Component.text(s));
            } else
                com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <message>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
