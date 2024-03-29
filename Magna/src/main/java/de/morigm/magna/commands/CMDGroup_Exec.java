package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getGroupManager;

public class CMDGroup_Exec extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("magna-group-exec");
        util().registerTranslation("cmd.group-exec");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "magna-group-exec")) {
            if (getGroupManager().getGroups().length >= 1) {
                if (args.length >= 2) {
                    Group group = getGroupManager().getGroup(args[0]);
                    for (Player t : getGroupManager().getPlayersByGroup(group))
                        Bukkit.dispatchCommand(com,
                                (args[1].startsWith("/") ? args[1].substring(1) : args[1]) + " "
                                        + t.getName());
                    com.sendPlainMessage(Chat.prefix + translate("cmd.group-exec"));
                } else
                    com.sendPlainMessage(Chat.prefix + Slash(com) + getCommand() + " <Group> <Command>");
            } else
                com.sendPlainMessage(Chat.prefix + Chat.no_group);
        } else
            Chat.noPermission(com);
        return false;
    }

}
