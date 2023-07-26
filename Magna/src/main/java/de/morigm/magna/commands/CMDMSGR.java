package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.utility.StringManipulator;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDMSGR extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerTranslation("cmd.msgr.error");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (args.length >= 1) {
                String target = Magna.getMSGManager().getLastMessagedPlayer(p);
                if (target != null) {
                    Player t = Bukkit.getPlayer(target);
                    if (t != null) {
                        String text = StringManipulator.stringArrayToString(args, " ").replace('&', '§');
                        t.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " -> "
                                + ChatColor.BLUE + t.getName() + ChatColor.GRAY + "]" + ChatColor.RESET + " " + text);
                    } else
                        Chat.noOnline(p);
                } else
                    p.sendMessage(Chat.prefix + translate("cmd.msgr.error"));
            } else
                p.sendMessage(Chat.prefix + "/" + getCommand() + " <MSG>");
        } else
            Chat.noConsole(com);

        return false;
    }

}
