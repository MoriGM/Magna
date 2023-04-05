package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class CMDSetItemName extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("setitemname");
        util().registerTranslation("cmd.setitemname.error");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (testPermission(p, "setitemname")) {
                if (args.length >= 1) {
                    if (p.getInventory().getItemInMainHand() != null
                            && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                        ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
                        meta.setDisplayName(args[0]);
                        p.getInventory().getItemInMainHand().setItemMeta(meta);
                    } else
                        p.sendMessage(Chat.prefix + translate("cmd.setitemname.error"));
                } else
                    p.sendMessage(Chat.prefix + "/" + getCommand() + " <name>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
