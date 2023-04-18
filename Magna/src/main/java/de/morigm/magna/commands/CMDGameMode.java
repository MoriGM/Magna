package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.helper.StringHelper;
import de.morigm.magna.chat.Chat;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDGameMode extends PluginCommand {
    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("gamemode");
        util().registerTranslation("cmd.gamemode");
        util().registerTranslation("cmd.gamemode.other");
        util().registerTranslation("cmd.gamemode.error");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (com instanceof Player p) {
            if (checkPermission(p, "gamemode")) {
                if (args.length >= 1) {
                    String gm = args[0].toLowerCase();

                    Player t = p;
                    if (args.length >= 2) {
                        t = Bukkit.getPlayer(args[1]);
                    }

                    if (t != null) {
                        org.bukkit.GameMode gamemode = null;

                        if (gm.equalsIgnoreCase("creative") || gm.equalsIgnoreCase("1") || gm.equalsIgnoreCase("c")) {
                            gamemode = org.bukkit.GameMode.CREATIVE;
                        }
                        if (gm.equalsIgnoreCase("survival") || gm.equalsIgnoreCase("0") || gm.equalsIgnoreCase("s")) {
                            gamemode = org.bukkit.GameMode.SURVIVAL;
                        }
                        if (gm.equalsIgnoreCase("adventure") || gm.equalsIgnoreCase("2") || gm.equalsIgnoreCase("a")) {
                            gamemode = org.bukkit.GameMode.ADVENTURE;
                        }
                        if (gm.equalsIgnoreCase("spectator") || gm.equalsIgnoreCase("3") || gm.equalsIgnoreCase("sp")) {
                            gamemode = org.bukkit.GameMode.SPECTATOR;
                        }

                        if (gamemode == null) {
                            p.sendMessage(Component.text(Chat.prefix + translate("cmd.gamemode.error")));
                            return false;
                        }
                        t.setGameMode(gamemode);
                        if (t == p) {
                            p.sendMessage(Component.text(Chat.prefix + translate("cmd.gamemode") + " "
                                    + StringHelper.toFirstUpAndRemainderLower(t.getGameMode().toString())));
                        } else {
                            p.sendMessage(Component.text(Chat.prefix + translate("cmd.gamemode.other") + " "
                                    + StringHelper.toFirstUpAndRemainderLower(t.getGameMode().toString())));
                        }

                    } else
                        Chat.noOnline(p);
                }
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
