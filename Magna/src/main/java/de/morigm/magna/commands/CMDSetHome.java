package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.helper.PlayerHelper;
import de.morigm.magna.api.home.Home;
import de.morigm.magna.chat.Chat;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.morigm.magna.api.Magna.getHomeManager;

public class CMDSetHome extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("sethome");
        util().registerTranslation("cmd.sethome");
        util().registerTranslation("cmd.sethome.max");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (PlayerHelper.isPlayer(com)) {
            Player p = (Player) com;
            if (testPermission(p, "sethome")) {
                if (args.length >= 1) {
                    String name = args[0];
                    Location loc = p.getLocation();
                    if (getHomeManager().maxPlayerHomes(p) > getHomeManager().getPlayerHomes(p).size()) {
                        Home home = new Home(name, loc);
                        getHomeManager().setHome(p, home);
                        p.sendMessage(Chat.prefix + translate("cmd.sethome"));
                    } else
                        p.sendMessage(Chat.prefix + translate("cmd.sethome.max"));
                } else
                    p.sendMessage(Chat.prefix + "/" + getCommand() + " <home>");
            } else
                Chat.noPermission(p);
        } else
            Chat.noConsole(com);
        return false;
    }

}
