package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.utility.PlayerConverter;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getOnlyBreakManager;

public class CMDOnlyBreak extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("onlybreak");
        util().registerTranslation("cmd.onlybreak.on");
        util().registerTranslation("cmd.onlybreak.off");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (PlayerConverter.isPlayer(com)) {
            if (checkPermission(com, "onlybreak")) {
                Player p = (Player) com;
                getOnlyBreakManager().togglePlayer(p);
                if (getOnlyBreakManager().containsPlayer(p))
                    p.sendMessage(Chat.prefix + translate("cmd.onlybreak.on"));
                else
                    p.sendMessage(Chat.prefix + translate("cmd.onlybreak.off"));
            } else
                Chat.noPermission(com);
        } else
            Chat.noConsole(com);
        return false;
    }

}
