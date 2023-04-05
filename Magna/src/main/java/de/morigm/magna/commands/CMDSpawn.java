package de.morigm.magna.commands;

import de.morigm.magna.Main;
import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDSpawn extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("spawn");
        util().registerTranslation("cmd.spawn");
        util().registerTranslation("cmd.spawn.error");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (p.hasPermission(getPermission("spawn"))) {
                if (Main.getInstance().getDefaultPluginConfig().spawn != null) {
                    p.teleport(Main.getInstance().getDefaultPluginConfig().spawn);
                    p.sendMessage(Chat.prefix + translate("cmd.spawn"));
                } else
                    p.sendMessage(Chat.prefix + translate("cmd.spawn.error"));
            } else
                Chat.noPermission(com);
        } else
            Chat.noConsole(com);
        return false;
    }

}
