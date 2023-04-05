package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDItemHead extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("itemhead");
        util().registerTranslation("cmd.itemhead");
        util().registerTranslation("cmd.itemhead.no");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (testPermission(p, "itemhead")) {
                if (p.getInventory().getItemInMainHand() != null
                        && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
                    p.sendMessage(Chat.prefix + translate("cmd.itemhead"));
                } else
                    p.sendMessage(Chat.prefix + translate("cmd.itemhead.no"));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
