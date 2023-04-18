package de.morigm.magna.commands;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getCommandSpyManager;

public class CMDPluginCommandSpy extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("cmdspy");
        util().registerTranslation("cmd.cmdspy");
        util().registerTranslation("cmd.cmdspy.on");
        util().registerTranslation("cmd.cmdspy.off");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "cmdspy")) {
                getCommandSpyManager().togglePlayer(p);
                p.sendMessage(Chat.prefix + translate("cmd.cmdspy") + " "
                        + (getCommandSpyManager().containsPlayer(p) ? (ChatColor.GREEN + translate("cmd.cmdspy.on"))
                        : (ChatColor.RED + translate("cmd.cmdspy.off"))));
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
