package de.morigm.magnaworld.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import de.morigm.magnaworld.api.MagnaWorld;
import de.morigm.magnaworld.api.world.WorldStruct;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class MWIMPORT extends PluginCommand {
    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("mwimport");
        util().registerTranslation("cmd.mwimport");
        util().registerTranslation("cmd.mwimport.error");
        util().registerTranslation("cmd.mwimport.missing");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull String[] args) {
        if (checkPermission(sender, "mwimport")) {
            if (args.length >= 1) {
                if (!MagnaWorld.containsWorld(args[0])) {
                    if (new File(args[0]).isDirectory()) {
                        WorldStruct ws = new WorldStruct(args[0]);
                        MagnaWorld.loadWorld(ws);
                        sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwimport"));
                    } else
                        sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwimport.missing"));
                } else
                    sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwimport.error"));
            } else
                sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + Slash(sender) + getCommand() + " <name>");
        } else
            Chat.noPermission(sender);
        return false;
    }

}
