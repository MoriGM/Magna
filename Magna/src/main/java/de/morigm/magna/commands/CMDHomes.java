package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.api.home.Home;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getHomeManager;

public class CMDHomes extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("homes");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (PlayerHelper.isPlayer(com)) {
            Player p = (Player) com;
            if (checkPermission(p, "homes")) {
                StringBuilder homes = new StringBuilder();
                for (Home h : getHomeManager().getPlayerHomes(p)) {
                    homes.append((homes.length() == 0) ? h.name() : "," + h.name());
                }
                p.sendMessage(Chat.prefix + "Homes:" + homes);
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
