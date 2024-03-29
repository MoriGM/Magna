package de.morigm.magna.api.gui;

import de.morigm.magna.Main;
import de.morigm.magna.api.manager.PermissionManager;
import de.morigm.magna.api.utility.Permission;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public abstract class Gui extends Permission {

    @Getter
    private final List<GuiButton> guiButtons = new ArrayList<>();
    private final PermissionManager permissionManager;
    @Getter
    @Setter
    private String name = "", permission = "";
    @Getter
    private int size = 9 * 3;
    @Getter
    private Player player;
    @Getter
    private Inventory inventory;

    public Gui() {
        this(Main.Companion.getInstance().getPermissionManager());
    }

    public Gui(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    public void setSize(int size) {
        if ((size % 9) == 0)
            this.size = size;
    }

    public abstract void load();

    public abstract void onClick(GuiButton button);

    public void addButton(GuiButton button) {
        if (button.getSlot() > this.getSize())
            return;

        for (GuiButton b : getGuiButtons())
            if (b.getSlot() >= 0 && button.getId() == b.getId())
                return;

        getGuiButtons().add(button);
    }

    public void createGUI(@NonNull Player player) {
        this.player = player;
        if (this.getName().isEmpty())
            this.inventory = Bukkit.createInventory(player, size);
        else
            this.inventory = Bukkit.createInventory(player, size, Component.text(name));
        for (GuiButton button : getGuiButtons()) {
            if (button.getSlot() >= 0) {
                this.inventory.setItem(button.getSlot(), button.getItem());
            }
        }
        for (GuiButton button : getGuiButtons().toArray(new GuiButton[0])) {
            if (button.getSlot() == -1) {
                int slot = this.inventory.firstEmpty();
                GuiButton gb = new GuiButton(button.getItem(), button.getId(), slot);
                getGuiButtons().remove(button);
                getGuiButtons().add(gb);
                this.inventory.setItem(slot, gb.getItem());
            }
        }
    }

    public void registerClick(int slot) {
        for (GuiButton button : getGuiButtons()) {
            if (button.getSlot() == slot) {
                this.onClick(button);
                return;
            }
        }
    }

    @Override
    public boolean checkPermission(CommandSender p, String permission) {
        return p.hasPermission(getPermission(permission));
    }

    @Override
    public String getPermission(String permission) {
        return permissionManager.getPermission(permission);
    }
}
