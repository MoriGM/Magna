package de.morigm.magnaworld.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.utility.FileGenerator;
import de.morigm.magna.chat.Chat;
import de.morigm.magnaworld.api.MagnaWorld;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MWDELETE extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("mwdelete");
        util().registerTranslation("cmd.mwdelete");
        util().registerTranslation("cmd.mwdelete.error");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (checkPermission(sender, "mwdelete")) {
            if (args.length >= 1) {
                String name = args[0];
                if (MagnaWorld.containsWorld(name)) {
                    if (name.startsWith("/"))
                        throw new NullPointerException();
                    Bukkit.unloadWorld(name, false);
                    List<File> files = new ArrayList<>();
                    FileGenerator.getFiles(files, new File(name));
                    FileGenerator.delete(files);
                    MagnaWorld.removeWorld(name);
                    sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwdelete"));
                } else
                    sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwdelete.error"));
            } else
                sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("/" + getCommand() + " <name>"));
        } else
            Chat.noPermission(sender);
        return false;
    }

}
