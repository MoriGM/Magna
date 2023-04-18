package de.morigm.magnaworld.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class MWLIST extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("mwlist");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (checkPermission(sender, "mwlist")) {
            String worlds = "";
            for (World w : Bukkit.getWorlds())
                worlds += w.getName() + ",";

            worlds = worlds.substring(0, worlds.length() - 1);

            sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + "Worlds:" + worlds);
        } else
            Chat.noPermission(sender);
        return false;
    }

}
