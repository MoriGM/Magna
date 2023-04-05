package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.command.Command;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.waypoint.WayPoint;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class CMDWayPoint extends Command {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("waypoint");
        util().registerTranslation("cmd.waypoint.set");
        util().registerTranslation("cmd.waypoint.get");
        util().registerTranslation("cmd.waypoint.get.error");
        util().registerTranslation("cmd.waypoint.remove");
    }

    @Override
    public boolean onCommand(CommandSender com, org.bukkit.command.Command command, String s, String[] args) {
        if (!isPlayer(com)) {
            Chat.noConsole(com);
            return false;
        }

        Player p = (Player) com;

        if (args.length < 2) {
            this.sendMessage(p, "<set,get,remove> <name>");
            return false;
        }

        if (Arrays.stream(new String[]{"set", "get", "remove"}).noneMatch(args[0]::equalsIgnoreCase)) {
            this.sendMessage(p, "<set,get, remove> <name>");
            return false;
        }

        if (args[0].equalsIgnoreCase("set")) {
            Magna.GetWayPointManager().SetWayPoint(args[1], p.getUniqueId().toString(), p.getLocation());
            this.sendMessageTranslate(p, "cmd.waypoint.set", new TextStruct("%NAME%", args[1]));
        }

        if (args[0].equalsIgnoreCase("get")) {
            if (!Magna.GetWayPointManager().ContainsWayPoint(args[1], p.getUniqueId().toString())) {
                this.sendMessageTranslate(p, "cmd.waypoint.get.error");
                return false;
            }

            WayPoint wayPoint = Magna.GetWayPointManager().GetWayPoint(args[1], p.getUniqueId().toString());
            this.sendMessageTranslate(p, "cmd.waypoint.get", new TextStruct("%NAME%", args[1]),
                    new TextStruct("%X%", String.valueOf(wayPoint.Location.getBlockX())),
                    new TextStruct("%Y%", String.valueOf(wayPoint.Location.getBlockY())),
                    new TextStruct("%Z%", String.valueOf(wayPoint.Location.getBlockZ())),
                    new TextStruct("%WORLD%", wayPoint.Location.getWorld().getName()));
        }

        if (args[0].equalsIgnoreCase("remove")) {
            Magna.GetWayPointManager().RemoveWarp(args[1], p.getUniqueId().toString());
            this.sendMessageTranslate(p, "cmd.waypoint.remove", new TextStruct("%NAME%", args[1]));

        }

        return false;
    }

}
