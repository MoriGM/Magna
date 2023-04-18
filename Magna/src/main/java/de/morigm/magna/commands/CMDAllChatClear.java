package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDAllChatClear extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("allchatclear");
        util().registerTranslation("cmd.allchatclear");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "allchatclear")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < 100; i++) {
                    p.sendMessage(Component.text(" "));
                }
                if (Magna.getSettings().getShowChatClear()) {
                    p.sendMessage(Component.text(Chat.prefix + translate("cmd.allchatclear") + " " + ((com instanceof Player) ? com.getName() : "Sever")));
                }
            }
        } else
            com.sendMessage(Component.text(Chat.prefix + Chat.no_permission));
        return false;
    }

}
