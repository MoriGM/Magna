package de.morigm.magna.api.gui;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.utility.ItemMetaManipulator;
import org.bukkit.Material;

public class GuiSwitchButton extends GuiButton {

    public GuiSwitchButton(Material m, String name, int id, boolean state) {
        this(m, name, id, -1, state);
    }

    public GuiSwitchButton(Material m, String name, int id, int slot, boolean state) {
        super(ItemMetaManipulator.changeName(m, (state ? ChatColor.DARK_GREEN : ChatColor.RED) + name), id, slot);
    }

}
