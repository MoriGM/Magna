package de.morigm.magna.commands;

import de.morigm.magna.api.command.Command;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDDamage extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("damage");
        util().registerTranslation("cmd.damage");
        util().registerTranslation("cmd.damage.noint");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (testPermission(com, "damage")) {
            if (args.length >= 2) {
                try {
                    int d = Integer.parseInt(args[1]);
                    Player t = Bukkit.getPlayer(args[0]);
                    if (t != null) {
                        t.damage(d);
                        com.sendMessage(Chat.prefix + translate("cmd.damage"));
                    } else
                        Chat.noOnline(com);
                } catch (Exception e) {
                    com.sendMessage(Chat.prefix + translate("cmd.damage.noint"));
                }
            } else
                com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Player> <Damage>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
