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

public class CMDMagna_Id extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("magna-id");
        util().registerTranslation("cmd.id.true");
        util().registerTranslation("cmd.id.false");
        util().registerTranslation("cmd.id.player");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "magna-id")) {
            if (getGroupManager().getGroups().length >= 1) {
                if (com instanceof Player t) {
                    if (args.length >= 1)
                        t = Bukkit.getPlayer(args[0]);
                    if (t != null) {
                        Group group = getGroupManager().getGroupFromPlayer(t);
                        if (group != null)
                            com.sendPlainMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " "
                                    + translate("cmd.id.true") + " " + group.name);
                        else
                            com.sendPlainMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " "
                                    + translate("cmd.id.false"));
                    } else
                        Chat.noOnline(com);
                } else {
                    if (args.length >= 1) {
                        Player t = Bukkit.getPlayer(args[0]);
                        if (t != null) {
                            Group group = getGroupManager().getGroupFromPlayer(t);
                            if (group != null)
                                com.sendPlainMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " "
                                        + translate("cmd.id.true") + " " + group.name);
                            else
                                com.sendPlainMessage(Chat.prefix + translate("cmd.id.player") + " " + t.getName() + " "
                                        + translate("cmd.id.false"));
                        } else
                            Chat.noOnline(com);
                    } else
                        Chat.writeMessage(getCommand() + " " + "<Player>");
                }
            } else
                com.sendPlainMessage(Chat.prefix + Chat.no_group);
        } else
            Chat.noPermission(com);
        return false;
    }

}
