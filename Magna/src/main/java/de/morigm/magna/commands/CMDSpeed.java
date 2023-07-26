package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.convert.Convert;
import de.morigm.magna.api.utility.PlayerConverter;
import de.morigm.magna.chat.Chat;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDSpeed extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("speed");
        util().registerTranslation("cmd.speed.you");
        util().registerTranslation("cmd.speed.player");
        util().registerTranslation("cmd.speed.error");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (PlayerConverter.isPlayer(sender)) {
            Player p = (Player) sender;
            if (checkPermission(p, "speed"))
                if (args.length >= 1) {
                    if (Convert.isInteger(args[0])) {
                        float f = Float.parseFloat(args[0]) / 10;

                        if (Integer.parseInt(args[0]) > 10 || Integer.parseInt(args[0]) < 0) {
                            p.sendMessage(Chat.prefix + translate("cmd.speed.error"));
                            return false;
                        }

                        Player t = args.length >= 2 ? Bukkit.getPlayer(args[1]) : p;
                        if (t != null) {
                            t.setWalkSpeed(f);
                            p.sendMessage(Chat.prefix + (t == p ? translate("cmd.speed.you")
                                    : translate("cmd.speed.player") + " " + args[1]));
                        } else
                            Chat.noOnline(p);
                    } else
                        Chat.noInt(p);
                } else
                    p.sendMessage(getCommand() + " <speed> [Player]");
            else
                Chat.noPermission(p);
        } else
            Chat.noConsole(sender);
        return false;
    }

}
