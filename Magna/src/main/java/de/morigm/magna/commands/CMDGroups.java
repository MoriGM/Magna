package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.api.chat.ChatColor;
import org.bukkit.command.CommandSender;

import static de.morigm.magna.api.Magna.getGroupManager;

public class CMDGroups extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("magna-groups");
        util().registerTranslation("cmd.groups");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (testPermission(com, "magna-groups")) {
            if (getGroupManager().getGroups().length >= 1) {
                String groups = "";
                for (Group group : getGroupManager().getGroups())
                    groups += ChatColor.GREEN + group.name + ChatColor.RESET + " ";
                if (groups.length() >= 2)
                    groups = groups.substring(0, groups.length() - 1);
                com.sendMessage(Chat.prefix + translate("cmd.groups") + ":" + groups);
            } else
                com.sendMessage(Chat.prefix + Chat.no_group);
        } else
            Chat.noPermission(com);
        return false;
    }

}
