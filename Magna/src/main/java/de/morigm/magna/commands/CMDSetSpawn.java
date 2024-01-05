package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDSetSpawn extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("setspawn");
        util().registerTranslation("cmd.setspawn");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(com, "setspawn")) {
                Magna.INSTANCE.getSettings().setSpawn(p.getLocation());
                p.sendMessage(Chat.prefix + translate("cmd.setspawn"));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);

        return false;
    }

}
