package de.morigm.magna.api.utility;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMetaManipulator {

    public static ItemStack changeName(ItemStack item, String text) {
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(text));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack changeName(Material m, String text) {
        return changeName(new ItemStack(m), text);
    }

}
