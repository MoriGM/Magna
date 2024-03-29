package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.utility.PlayerConverter;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getHomeManager;

public class CMDDeleteHome extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("deletehome");
        util().registerTranslation("cmd.deletehome");
        util().registerTranslation("cmd.deletehome.exists");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (PlayerConverter.isPlayer(com)) {
            Player p = (Player) com;
            if (checkPermission(p, "deletehome")) {
                if (args.length >= 1) {
                    String name = args[0];
                    if (getHomeManager().hasHome(p, name)) {
                        getHomeManager().removeHome(p, name);
                        p.sendMessage(Chat.prefix + translate("cmd.deletehome"));
                    } else
                        p.sendMessage(Chat.prefix + translate("cmd.deletehome.exists"));
                } else
                    p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <home>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
