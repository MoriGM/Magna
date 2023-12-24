package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.BanEntry;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ban.ProfileBanList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDBans extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("bans");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "bans")) {
            StringBuilder bans = new StringBuilder();
            ProfileBanList list = Bukkit.getBanList(Type.PROFILE);
            for (BanEntry<?> ban : list.getEntries()) {
                bans.append(ban.getBanTarget()).append(" ");
            }
            com.sendPlainMessage("Bans:" + bans);
        } else
            com.sendPlainMessage(Chat.prefix + Chat.no_permission);
        return false;
    }

}
