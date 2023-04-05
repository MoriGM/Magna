package de.morigm.magna.api.sign;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.PermissionHelper;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.translation.Translation;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SignListener implements Translation, PermissionHelper {

    @Getter
    private String name;
    private PermissionManager permission;
    private Language language;

    public abstract boolean onCreate(String[] lines, Player player, Block sign);

    public abstract void onClick(Sign sign, Player player);

    public void register(String name) {
        register(name, Main.getInstance() != null ? Magna.getLanguage() : null,
                Main.getInstance() != null ? Magna.getPermissionManager() : null);
    }

    public void register(String name, Language language) {
        register(name, language, Main.getInstance() != null ? Magna.getPermissionManager() : null);
    }

    public void register(String name, PermissionManager manager) {
        register(name, Main.getInstance() != null ? Magna.getLanguage() : null, manager);
    }

    public void register(String name, Language language, PermissionManager manager) {
        this.name = name;
        if (language != null)
            this.language = language;
        if (manager != null)
            this.permission = manager;
        Magna.getSignManager().registerSign(this);
    }

    @Override
    public String translate(String text, TextStruct... structs) {
        return language.translate(text, structs);
    }

    @Override
    public String getPermission(String Permission) {
        return this.permission.getPermission(Permission);
    }

    @Override
    public boolean testPermission(CommandSender p, String permission) {
        return p.hasPermission(this.getPermission(permission));
    }

}
