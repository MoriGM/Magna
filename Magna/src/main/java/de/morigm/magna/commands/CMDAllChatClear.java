package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDAllChatClear extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("allchatclear");
        util().registerTranslation("cmd.allchatclear");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (testPermission(com, "allchatclear")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < 100; i++)
                    p.sendMessage(" ");
                if (Magna.getSettings().getShowChatClear())
                    p.sendMessage(Chat.prefix + translate("cmd.allchatclear") + " "
                            + ((com instanceof Player) ? com.getName() : "Sever"));
            }
        } else
            com.sendMessage(Chat.prefix + Chat.no_permission);
        return false;
    }

}
