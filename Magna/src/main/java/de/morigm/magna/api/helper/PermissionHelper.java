package de.morigm.magna.api.helper;

import org.bukkit.command.CommandSender;

import static de.morigm.magna.api.Magna.getPermissionManager;

public abstract class PermissionHelper {

    public String getPermission(String Permission) {
        return getPermissionManager().getPermission(Permission);
    }

    public boolean checkPermission(CommandSender p, String permission) {
        return p.hasPermission(getPermission(permission));
    }

}
