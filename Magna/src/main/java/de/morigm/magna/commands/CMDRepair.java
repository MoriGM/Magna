package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.items.ItemIs;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class CMDRepair extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("repair");
        util().registerTranslation("cmd.repair");
        util().registerTranslation("cmd.repair.error");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender com, @NonNull org.bukkit.command.Command cmd, @NonNull String label, @NonNull String[] args) {
        if (isPlayer(com)) {
            Player p = (Player) com;
            if (checkPermission(p, "repair")) {
                if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR)
                        && ItemIs.repairable(p.getInventory().getItemInMainHand())) {
                    ItemStack item = p.getInventory().getItemInMainHand();
                    ItemMeta meta = item.getItemMeta();
                    if (meta instanceof Damageable)
                        ((Damageable) meta).setDamage(0);
                    item.setItemMeta(meta);
                    p.sendMessage(Chat.prefix + translate("cmd.repair"));
                } else
                    p.sendMessage(Chat.prefix + translate("cmd.repair.error"));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
