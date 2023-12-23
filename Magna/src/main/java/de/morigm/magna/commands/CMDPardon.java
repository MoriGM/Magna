package de.morigm.magna.commands;

import com.destroystokyo.paper.profile.PlayerProfile;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.ban.ProfileBanList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDPardon extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("pardon");
        util().registerTranslation("cmd.pardon");
        util().registerTranslation("cmd.pardon.other");

    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "pardon")) {
            if (args.length >= 1) {
                String t = args[0];
                ProfileBanList banList = Bukkit.getBanList(Type.PROFILE);
                OfflinePlayer target = Bukkit.getOfflinePlayer(t);
                PlayerProfile targetProfile = target.getPlayerProfile();

                if (banList.isBanned(targetProfile)) {
                    banList.pardon(targetProfile);
                    com.sendPlainMessage(Chat.prefix + translate("cmd.pardon"));
                } else
                    com.sendPlainMessage(Chat.prefix + translate("cmd.pardon.error"));
            } else
                com.sendPlainMessage(Chat.prefix + Slash(com) + getCommand() + " <Player>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
