package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class CMDSetItemName extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("setitemname");
        util().registerTranslation("cmd.setitemname.error");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "setitemname")) {
                if (args.length >= 1) {
                    if (p.getInventory().getItemInMainHand() != null
                            && !p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                        ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
                        meta.displayName(Component.text(args[0]));
                        p.getInventory().getItemInMainHand().setItemMeta(meta);
                    } else
                        p.sendPlainMessage(Chat.prefix + translate("cmd.setitemname.error"));
                } else
                    p.sendPlainMessage(Chat.prefix + "/" + getCommand() + " <name>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
