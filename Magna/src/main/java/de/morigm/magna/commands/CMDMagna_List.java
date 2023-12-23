package de.morigm.magna.commands;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static de.morigm.magna.api.Magna.getGroupManager;

public class CMDMagna_List extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("magna-list");
        util().registerTranslation("cmd.list.player");
        util().registerTranslation("cmd.list.group.notfound");
        util().registerTranslation("cmd.list.player");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "magna-list")) {
            if (getGroupManager().getGroups().length >= 1) {
                if (Bukkit.getOnlinePlayers().size() >= 1) {
                    if (args.length >= 1) {
                        Group group = getGroupManager().getGroup(args[0]);
                        if (group != null) {
                            List<Player> players = getGroupManager().getPlayersByGroup(group);
                            StringBuilder groups = new StringBuilder();
                            for (Player t : players) {
                                groups.append(ChatColor.GREEN).append(t.getName()).append(ChatColor.RESET).append(" ");
                            }
                            com.sendPlainMessage(Chat.prefix + translate("cmd.list.player") + ":" + groups);
                        } else
                            com.sendPlainMessage(Chat.prefix + translate("cmd.list.group.notfound"));
                    } else {
                        Map<Player, Group> map = getGroupManager().getOnlinePlayerWithGroup();
                        StringBuilder group = new StringBuilder();
                        for (Entry<Player, Group> entry : map.entrySet()) {
                            group.append("(").append(entry.getKey().getName()).append(" : ").append(entry.getValue() != null ? entry.getValue().name() : translate("cmd.list.group.no")).append("),");
                        }
                        group = new StringBuilder(group.substring(0, group.length() - 1));
                        com.sendPlainMessage(Chat.prefix + group);
                    }
                } else
                    Chat.noPlayer(com);
            } else
                com.sendPlainMessage(Chat.prefix + Chat.no_group);
        } else
            Chat.noPermission(com);
        return false;
    }

}
