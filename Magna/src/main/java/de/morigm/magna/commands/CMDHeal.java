package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDHeal extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("heal");
        util().registerTranslation("cmd.heal.you");
        util().registerTranslation("cmd.heal.player");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player t) {
            if (checkPermission(com, "heal")) {
                if (args.length >= 1)
                    t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    t.setHealth(t.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    t.setFoodLevel(20);
                    com.sendPlainMessage(Chat.prefix
                            + (t == com ? translate("cmd.heal.you") : translate("cmd.heal.player")));
                } else
                    Chat.noOnline(com);
            } else
                Chat.noPermission(com);
        } else
            Chat.noConsole(com);
        return false;
    }

}
