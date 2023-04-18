package de.morigm.magna.commands;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class CMDTrash extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("trash");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "trash")) {
                Inventory inv = Bukkit.createInventory(null, (9 * 6), Component.text(ChatColor.RED + "Trash"));
                p.openInventory(inv);
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
