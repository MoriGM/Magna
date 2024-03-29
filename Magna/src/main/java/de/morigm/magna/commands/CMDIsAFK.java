package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDIsAFK extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("isafk");
        util().registerTranslation("cmd.isafk.on");
        util().registerTranslation("cmd.isafk.off");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "isafk")) {
            if (args.length >= 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (Magna.getAFKManager().isAfk(t))
                        com.sendPlainMessage(Chat.prefix + translate("cmd.isafk.on"));
                    else
                        com.sendPlainMessage(Chat.prefix + translate("cmd.isafk.off"));
                } else
                    Chat.noOnline(com);
            } else
                com.sendPlainMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
