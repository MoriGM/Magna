package de.morigm.magna.commands;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.waypoint.WayPoint;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CMDWayPoint extends CommandHelper {

    @Override
    public void registerUtils() 	{
        Util().registerCommandName(getCommand());
        Util().registerPermission("waypoint");
        Util().registerTranslation("cmd.waypoint.set");
        Util().registerTranslation("cmd.waypoint.get");
        Util().registerTranslation("cmd.waypoint.get.error");
        Util().registerTranslation("cmd.waypoint.remove");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!isPlayer(com)) {
            Chat.noConsole(com);
            return false;
        }

        Player p = (Player) com;

        if(args.length < 2) {
            this.SendMessage(p, "<set,get,remove> <name>");
            return false;
        }

        if(Arrays.stream(new String[]{"set", "get", "remove"}).noneMatch(args[0]::equalsIgnoreCase)) {
            this.SendMessage(p, "<set,get, remove> <name>");
            return false;
        }

        if(args[0].equalsIgnoreCase("set")) {
            Magna.GetWayPointManager().SetWayPoint(args[1], p.getUniqueId().toString(), p.getLocation());
            this.SendMessageTranslate(p, "cmd.waypoint.set", new TextStruct("%NAME%", args[1]));
        }

        if(args[0].equalsIgnoreCase("get")) {
            if(!Magna.GetWayPointManager().ContainsWayPoint(args[1], p.getUniqueId().toString())) {
                this.SendMessageTranslate(p, "cmd.waypoint.get.error");
                return false;
            }

            WayPoint wayPoint = Magna.GetWayPointManager().GetWayPoint(args[1], p.getUniqueId().toString());
            this.SendMessageTranslate(p, "cmd.waypoint.get",
                    new TextStruct("%NAME%", args[1]),
                    new TextStruct("%X%", String.valueOf(wayPoint.Location.getBlockX())),
                    new TextStruct("%Y%", String.valueOf(wayPoint.Location.getBlockY())),
                    new TextStruct("%Z%", String.valueOf(wayPoint.Location.getBlockZ())),
                    new TextStruct("%WORLD%", String.valueOf(wayPoint.Location.getWorld().getName()))
            );
        }

        if(args[0].equalsIgnoreCase("remove")) {
            Magna.GetWayPointManager().RemoveWarp(args[1], p.getUniqueId().toString());
            this.SendMessageTranslate(p, "cmd.waypoint.remove", new TextStruct("%NAME%", args[1]));

        }

        return false;
    }

}
