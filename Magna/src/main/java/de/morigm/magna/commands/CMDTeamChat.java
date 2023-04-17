package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.Bukkit;
import de.morigm.magna.api.chat.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDTeamChat extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("teamchat");
        util().registerPermission("teamchat-see");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command cmd, String label, String[] args) {
        if (testPermission(com, "teamchat")) {
            if (args.length >= 1) {
                String s = "";
                for (String arg : args)
                    s += arg + " ";
                s = s.trim();
                for (Player t : Bukkit.getOnlinePlayers())
                    if (testPermission(t, "teamchat-see"))
                        t.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "TeamChat" + ChatColor.GRAY + "]"
                                + ChatColor.RESET + "<" + (com instanceof Player ? com.getName() : "SERVER")
                                + ">" + s);
            } else
                com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Text>");
        } else
            Chat.noPermission(com);
        return false;
    }

}
