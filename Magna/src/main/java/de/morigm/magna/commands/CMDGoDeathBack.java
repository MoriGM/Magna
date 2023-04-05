package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.api.deathback.DeathBack;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getDeathBackManager;

public class CMDGoDeathBack extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("deathback");
        util().registerTranslation("cmd.deathback");
        util().registerTranslation("cmd.deathback.error");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (testPermission(p, "deathback")) {
                if (getDeathBackManager().hasDeathBack(p)) {
                    DeathBack db = getDeathBackManager().getDeathBack(p);
                    p.teleport(db.location);
                    p.sendMessage(Chat.prefix + translate("cmd.deathback"));
                } else
                    p.sendMessage(Chat.prefix + translate("cmd.deathback.error"));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
