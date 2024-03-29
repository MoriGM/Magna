package de.morigm.magna.commands;

import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.censor.CensorType;
import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getBlackListManager;

public class CMDCensor extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("censor");
        util().registerPermission("blacklistword");
        util().registerTranslation("cmd.censor.add");
        util().registerTranslation("cmd.censor.add.error");
        util().registerTranslation("cmd.censor.remove");
        util().registerTranslation("cmd.censor.remove.error");
        util().registerTranslation("cmd.censor.words");
        util().registerTranslation("cmd.censor.or");
        util().registerTranslation("cmd.censor.type");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "censor")) {
            if (args.length >= 2) {
                String word = args[1];

                if (args[0].equalsIgnoreCase("add")) {
                    if (!getBlackListManager().containsBlackWord(word)) {
                        String permission = getPermission("blacklistword");
                        CensorType type = CensorType.NORMAL;
                        if (args.length >= 3)
                            permission = args[2];
                        if (args.length >= 4)
                            type = CensorType.getType(args[3]);
                        BlackWord bword = new BlackWord(word, permission, type);
                        getBlackListManager().addBlackWord(bword);
                        com.sendPlainMessage(Chat.prefix + translate("cmd.censor.add"));
                    } else
                        com.sendPlainMessage(Chat.prefix + translate("cmd.censor.add.error"));
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if (getBlackListManager().containsBlackWord(word)) {
                        getBlackListManager().removeBlackWord(getBlackListManager().getBlackWord(word));
                        com.sendPlainMessage(Chat.prefix + translate("cmd.censor.remove"));
                    } else
                        com.sendPlainMessage(Chat.prefix + translate("cmd.censor.remove.error"));
                } else
                    com.sendPlainMessage(
                            Chat.prefix + Slash(com) + getCommand() + " <add,remove> <word> [permission] [type] "
                                    + translate("cmd.censor.or") + Slash(com) + getCommand() + " <list,types>");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    StringBuilder words = new StringBuilder();
                    for (BlackWord bword : getBlackListManager().getBlackWords()) {
                        words.append(bword.word).append(",");
                    }
                    if (!words.isEmpty()) {
                        words = new StringBuilder(words.substring(0, words.length() - 1));
                    }
                    com.sendPlainMessage(Chat.prefix + translate("cmd.censor.words") + ":" + words);
                } else if (args[0].equalsIgnoreCase("types"))
                    com.sendPlainMessage(Chat.prefix + translate("cmd.censor.type") + ":" + getTypes());
                else
                    com.sendPlainMessage(
                            Chat.prefix + Slash(com) + getCommand() + " <add,remove> <word> [permission] [type] "
                                    + translate("cmd.censor.or") + Slash(com) + getCommand() + " <list,types>");
            } else
                com.sendPlainMessage(Chat.prefix + Slash(com) + getCommand() + " <add,remove> <word> [permission] [type] "
                        + translate("cmd.censor.or") + Slash(com) + getCommand() + " <list,types>");
        } else
            Chat.noPermission(com);
        return false;
    }

    public String getTypes() {
        StringBuilder types = new StringBuilder();
        for (CensorType type : CensorType.values())
            types.append(type.name()).append(", ");
        if (!types.isEmpty())
            types = new StringBuilder(types.substring(0, types.length() - 2));
        return types.toString();
    }

}
