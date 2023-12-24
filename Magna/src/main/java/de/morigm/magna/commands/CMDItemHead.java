package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDItemHead extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("itemhead");
        util().registerTranslation("cmd.itemhead");
        util().registerTranslation("cmd.itemhead.no");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "itemhead")) {
                if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
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
