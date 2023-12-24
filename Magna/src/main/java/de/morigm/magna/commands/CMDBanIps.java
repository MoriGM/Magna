package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import net.kyori.adventure.text.Component;
import org.bukkit.BanEntry;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ban.IpBanList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.net.InetAddress;

public class CMDBanIps extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("banips");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender com, @NonNull Command cmd, @NonNull String label, @NonNull String[] args) {
        if (checkPermission(com, "banips")) {
            StringBuilder bans = new StringBuilder();
            IpBanList list = Bukkit.getBanList(Type.IP);
            for (BanEntry<? super InetAddress> ban : list.getEntries()) {
                bans.append(ban.getBanTarget()).append(" ");
            }
            com.sendMessage(Component.text("BanIps:" + bans));
        } else
            com.sendMessage(Component.text(Chat.prefix + Chat.no_permission));
        return false;
    }

}
