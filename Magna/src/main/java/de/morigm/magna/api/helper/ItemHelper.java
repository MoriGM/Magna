package de.morigm.magna.api.helper;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemHelper {

    public static ItemStack getItem(ItemStack item, String text) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(text);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getItem(Material m, String text) {
        return getItem(new ItemStack(m), text);
    }

}
