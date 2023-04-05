package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDSetSpawn extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("setspawn");
        util().registerTranslation("cmd.setspawn");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (testPermission(com, "setspawn")) {
                Magna.getSettings().setSpawn(p.getLocation());
                p.sendMessage(Chat.prefix + translate("cmd.setspawn"));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);

        return false;
    }

}
