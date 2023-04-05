package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDNight extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("night");
        util().registerTranslation("cmd.night");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command command, String label, String[] args) {
        if (testPermission(com, "night")) {
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
