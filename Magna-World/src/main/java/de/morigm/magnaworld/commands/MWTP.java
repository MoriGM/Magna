package de.morigm.magnaworld.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MWTP extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("mwtp");
        util().registerTranslation("cmd.mwtp");
        util().registerTranslation("cmd.mwtp.error");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull String[] args) {
        if (PlayerHelper.isPlayer(sender))
            if (checkPermission(sender, "mwtp")) {
                Player p = (Player) sender;
                if (args.length >= 1) {
                    String name = args[0];
                    World w = Bukkit.getWorld(name);
                    if (w != null) {
                        p.teleport(w.getSpawnLocation());
                        p.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwtp"));
                    } else
                        p.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwtp.error"));
                } else
                    p.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("/" + getCommand() + " <name>"));
            } else
                Chat.noPermission(sender);
        else
            Chat.noConsole(sender);
        return false;
    }

}
