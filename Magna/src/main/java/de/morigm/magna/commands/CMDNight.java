package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDNight extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("night");
        util().registerTranslation("cmd.night");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender com, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (checkPermission(com, "night")) {
            if (com instanceof Player p) {
                p.getWorld().setTime(16000);
                p.sendMessage(Chat.prefix + translate("cmd.night"));
            } else
                Chat.noConsole(com);
        } else
            Chat.noPermission(com);
        return false;
    }

}
