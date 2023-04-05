package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDOpenEnderChest extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("enderchest");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (p.hasPermission(getPermission("enderchest")))
                p.openInventory(p.getEnderChest());
            else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
