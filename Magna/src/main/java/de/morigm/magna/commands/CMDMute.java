package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.morigm.magna.api.Magna.getMutedPlayerManager;

public class CMDMute extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("mute");
        util().registerTranslation("cmd.mute.list");
        util().registerTranslation("cmd.mute.or");
        util().registerTranslation("cmd.mute.on");
        util().registerTranslation("cmd.mute.on.error");
        util().registerTranslation("cmd.mute.off");
        util().registerTranslation("cmd.mute.off.error");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command command, String label, String[] args) {
        if (testPermission(com, "mute")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    String players = "";
                    for (String uuid : getMutedPlayerManager().getMutedUUIDS()) {
                        OfflinePlayer t = Bukkit.getPlayer(UUID.fromString(uuid));
                        players += t.getName() + " ";
                    }
                    com.sendMessage(Chat.prefix + translate("cmd.mute.list") + ": " + players);
                } else
                    com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <on,off,status> <player> "
                            + translate("cmd.mute.or") + " " + (com instanceof Player ? "/" : "") + getCommand()
                            + " <list>");
            } else {
                if (args.length >= 2) {
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t != null) {
                        if (args[0].equalsIgnoreCase("on")) {
                            if (!getMutedPlayerManager().containsPlayer(t)) {
                                getMutedPlayerManager().addPlayer(t);
                                com.sendMessage(Chat.prefix + translate("cmd.mute.on"));
                            } else
                                com.sendMessage(Chat.prefix + translate("cmd.mute.on.error"));
                        } else if (args[0].equalsIgnoreCase("off")) {
                            if (getMutedPlayerManager().containsPlayer(t)) {
                                getMutedPlayerManager().removePlayer(t);
                                com.sendMessage(Chat.prefix + translate("cmd.mute.off"));
                            } else
                                com.sendMessage(Chat.prefix + translate("cmd.mute.off.error"));
                        } else if (args[0].equalsIgnoreCase("status")) {
                            com.sendMessage(Chat.prefix + translate("cmd.mute.status") + " "
                                    + (!getMutedPlayerManager().containsPlayer(t)
                                    ? (translate("cmd.mute.status.not") + " " + ChatColor.GREEN)
                                    : ChatColor.RED.toString())
                                    + "muted");
                        } else
                            com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <on,off,status> <player> "
                                    + translate("cmd.mute.or") + " " + Slash(com) + getCommand() + " <list>");
                    } else
                        Chat.noPlayer(com);
                } else {
                    com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <on,off,status> <player> "
                            + translate("cmd.mute.or") + " " + Slash(com) + getCommand() + " <list>");
                }
            }
        } else
            Chat.noPermission(com);
        return false;
    }

}
