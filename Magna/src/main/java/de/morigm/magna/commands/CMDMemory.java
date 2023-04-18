package de.morigm.magna.commands;

import de.morigm.magna.api.command.PluginCommand;
import de.morigm.magna.api.memory.MemoryManager.MemoryType;
import de.morigm.magna.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static de.morigm.magna.api.Magna.getMemoryManager;

public class CMDMemory extends PluginCommand {

    @Override
    public void registerUtils() {
        util().registerCommandName(getCommand());
        util().registerPermission("memory");
        util().registerTranslation("cmd.memory.used");
        util().registerTranslation("cmd.memory.free");
        util().registerTranslation("cmd.memory.total");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender com, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (checkPermission(com, "memory")) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("GIGABYTE") || args[0].equalsIgnoreCase("GB")) {
                    com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":"
                            + getMemoryManager().getUsedMemory(MemoryType.GIGABYTE) + "GB");
                    com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":"
                            + getMemoryManager().getFreeMemory(MemoryType.GIGABYTE) + "GB");
                    com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":"
                            + getMemoryManager().getTotalMemory(MemoryType.GIGABYTE) + "GB");
                } else if (args[0].equalsIgnoreCase("MEGABYTE") || args[0].equalsIgnoreCase("MB")) {
                    com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":"
                            + getMemoryManager().getUsedMemory(MemoryType.MEGABYTE) + "MB");
                    com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":"
                            + getMemoryManager().getFreeMemory(MemoryType.MEGABYTE) + "MB");
                    com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":"
                            + getMemoryManager().getTotalMemory(MemoryType.MEGABYTE) + "MB");
                } else if (args[0].equalsIgnoreCase("KILOBYTE") || args[0].equalsIgnoreCase("KB")) {
                    com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":"
                            + getMemoryManager().getUsedMemory(MemoryType.KILOBYTE) + "KB");
                    com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":"
                            + getMemoryManager().getFreeMemory(MemoryType.KILOBYTE) + "KB");
                    com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":"
                            + getMemoryManager().getTotalMemory(MemoryType.KILOBYTE) + "KB");
                } else
                    com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <GIGABYTE,MEGABYTE,KILOBYTE>");
            } else {
                com.sendMessage(Chat.prefix + translate("cmd.memory.used") + ":"
                        + getMemoryManager().getUsedMemory(MemoryType.MEGABYTE) + "MB");
                com.sendMessage(Chat.prefix + translate("cmd.memory.free") + ":"
                        + getMemoryManager().getFreeMemory(MemoryType.MEGABYTE) + "MB");
                com.sendMessage(Chat.prefix + translate("cmd.memory.total") + ":"
                        + getMemoryManager().getTotalMemory(MemoryType.MEGABYTE) + "MB");
            }
        } else
            Chat.noPermission(com);
        return false;
    }

}
