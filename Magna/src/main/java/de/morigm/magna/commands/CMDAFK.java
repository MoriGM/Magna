package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDAFK extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            Magna.getAFKManager().togglePlayer(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
