package de.morigm.magna.commands;

import de.morigm.magna.Main;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CMDReloadConfig extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("magna-reloadconfig");
        util().registerTranslation("cmd.reloadconfig");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "magna-reloadconfig")) {
            Main.Companion.getInstance().reloadConfig();
            Main.Companion.getInstance().getDefaultPluginConfig().load();
            if (Main.Companion.getInstance().getDefaultPluginConfig().groups.size() >= 1) {
                Main.Companion.getInstance().getGroupConfig().load();
                Main.Companion.getInstance().getGroupLoader().load();
            }
            com.sendPlainMessage(Chat.prefix + translate("cmd.reloadconfig"));
        } else
            Chat.noPermission(com);
        return false;
    }

}
