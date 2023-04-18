package de.morigm.magnaworld.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.convert.Convert;
import de.morigm.magna.chat.Chat;
import de.morigm.magnaworld.api.MagnaWorld;
import de.morigm.magnaworld.api.helper.WorldHelper;
import de.morigm.magnaworld.api.world.WorldStruct;
import lombok.NonNull;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class MWCREATE extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("mwcreate");
        util().registerTranslation("cmd.mwcreate");
        util().registerTranslation("cmd.mwcreate.error");
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        if (checkPermission(sender, "mwcreate")) {
            if (args.length >= 3 && WorldHelper.isEnvironment(args[1]) && WorldHelper.isWorldType(args[2])) {
                String name = args[0];
                if (!MagnaWorld.containsWorld(name)) {
                    WorldType type = WorldType.valueOf(args[2]);
                    Environment ev = Environment.valueOf(args[1]);
                    Long seed = null;
                    if (args.length >= 4 && Convert.isInteger(args[3]))
                        seed = Long.valueOf(args[3]);
                    WorldStruct ws = new WorldStruct(name, seed);
                    MagnaWorld.registerWorld(ws, type, ev);
                    sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwcreate"));
                } else
                    sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + translate("cmd.mwcreate.error"));
            } else
                sender.sendMessage(de.morigm.magnaworld.chat.Chat.prefix + Slash(sender) + getCommand()
                        + " <name> <NORMAL,NETHER,THE_END> <NORMAL,FLAT,LARGE_BIOMES,AMPLIFIED,CUSTOMIZED> [seed]");
        } else
            Chat.noPermission(sender);
        return false;
    }

}
