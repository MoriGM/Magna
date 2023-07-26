package de.morigm.magna.api.utility;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerConverter {

    public static boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    public static Player toPlayer(CommandSender sender) {
        return (Player) sender;
    }

}
