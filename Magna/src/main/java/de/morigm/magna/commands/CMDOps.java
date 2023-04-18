package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDOps extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("ops");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "ops")) {
            String ops = "";
            for (OfflinePlayer of : Bukkit.getOperators())
                ops += of.getName() + ",";
            ops = ops.substring(0, ops.length() - 1);
            com.sendMessage("Ops:" + ops);
        } else
            Chat.noPermission(com);
        return false;
    }

}
