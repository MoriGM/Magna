package de.morigm.magna.api.helper;

import org.bukkit.command.CommandSender;

import static de.morigm.magna.api.Magna.getPermissionManager;

public interface PermissionHelper {

    default String getPermission(String Permission) {
        return getPermissionManager().getPermission(Permission);
    }

    default boolean testPermission(CommandSender p, String permission) {
        return p.hasPermission(getPermission(permission));
    }

}
