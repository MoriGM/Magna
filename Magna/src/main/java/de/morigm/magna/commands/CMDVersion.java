package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.utility.PlayerConverter;
import de.morigm.magna.chat.Chat;
import de.morigm.magna.gui.DebugGui;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CMDVersion extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("version");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (PlayerConverter.isPlayer(sender) && !checkPermission(sender, "version")) {
            Chat.noPermission(sender);
            return false;
        }
        if (args.length >= 1 && PlayerConverter.isPlayer(sender))
            if (args[0].equalsIgnoreCase("debug") && Magna.INSTANCE.getSettings().getDebug()) {
                DebugGui gui = new DebugGui();
                Magna.getUser(PlayerConverter.toPlayer(sender)).openGui(gui);
            }

        sender.sendMessage(Chat.prefix + "Version:" + Chat.version);

        return false;
    }

}
