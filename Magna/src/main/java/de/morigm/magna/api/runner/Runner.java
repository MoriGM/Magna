package de.morigm.magna.api.runner;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.PermissionHelper;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.language.TextStruct;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.translation.Translation;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Runner extends PermissionHelper implements Translation {

    @Getter
    private String name;
    private BukkitRunnable bukkitRunnable;
    private Language language;
    private PermissionManager permission;
    @Getter
    private RunnerType type;

    public abstract void run();

    public void init() {
    }

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
        if (permission != null)
            this.permission = manager;
        Magna.getRunnerManager().registerRunner(this);
    }

    public void load(RunnerType type, BukkitRunnable bukkitRunnable) {
        this.type = type;
        this.bukkitRunnable = bukkitRunnable;
        init();
    }

    public void cancel() {
        this.bukkitRunnable.cancel();
        close();
    }

    public void close() {
        this.type = RunnerType.UNLOAD;
        this.removeBukkitRunnable();
    }

    public boolean isRunning() {
        return this.bukkitRunnable != null;
    }

    public void removeBukkitRunnable() {
        this.bukkitRunnable = null;
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
    public boolean checkPermission(CommandSender p, String permission) {
        return p.hasPermission(this.getPermission(permission));
    }

}
