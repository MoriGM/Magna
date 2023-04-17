package de.morigm.magna.commands;

import de.morigm.magna.Main;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDSetWarp extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("setwarp");
        util().registerTranslation("cmd.setwarp.warp");
        util().registerTranslation("cmd.setwarp.end");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (com instanceof Player p) {
            if (testPermission(p, "setwarp")) {
                if (args.length >= 1) {
                    String warpname = args[0];
                    if (Main.getInstance().getWarpManager().containsWarp(warpname))
                        Main.getInstance().getWarpManager().removeWarp(warpname);
                    Main.getInstance().getWarpManager().setWarp(warpname, p.getLocation());
                    p.sendMessage(Chat.prefix + translate("cmd.setwarp.warp") + " " + warpname + " "
                            + translate("cmd.setwarp.end"));
                } else
                    p.sendMessage(Chat.prefix + "/" + getCommand() + " <warp>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
