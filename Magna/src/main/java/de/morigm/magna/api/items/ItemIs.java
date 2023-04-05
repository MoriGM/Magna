package de.morigm.magna.api.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemIs {

    public static boolean equalType(ItemStack item, Material material) {
        return item.getType().equals(material);
    }

    public static boolean equal(ItemStack first, ItemStack second) {
        return first.getType().equals(second.getType());
    }

    public static boolean sword(ItemStack item) {
        return equalType(item, Material.DIAMOND_SWORD) || equalType(item, Material.GOLDEN_SWORD)
                || equalType(item, Material.WOODEN_SWORD) || equalType(item, Material.IRON_SWORD)
                || equalType(item, Material.STONE_SWORD);
    }

    public static boolean helmet(ItemStack item) {
        return equalType(item, Material.CHAINMAIL_HELMET) || equalType(item, Material.DIAMOND_HELMET)
                || equalType(item, Material.GOLDEN_HELMET) || equalType(item, Material.IRON_HELMET)
                || equalType(item, Material.LEATHER_HELMET);
    }

    public static boolean boots(ItemStack item) {
        return equalType(item, Material.CHAINMAIL_BOOTS) || equalType(item, Material.DIAMOND_BOOTS)
                || equalType(item, Material.GOLDEN_BOOTS) || equalType(item, Material.IRON_BOOTS)
                || equalType(item, Material.LEATHER_BOOTS);
    }

    public static boolean chestPlate(ItemStack item) {
        return equalType(item, Material.CHAINMAIL_CHESTPLATE) || equalType(item, Material.DIAMOND_CHESTPLATE)
                || equalType(item, Material.GOLDEN_CHESTPLATE) || equalType(item, Material.IRON_CHESTPLATE)
                || equalType(item, Material.LEATHER_CHESTPLATE);
    }

    public static boolean leggings(ItemStack item) {
        return equalType(item, Material.CHAINMAIL_LEGGINGS) || equalType(item, Material.DIAMOND_LEGGINGS)
                || equalType(item, Material.GOLDEN_LEGGINGS) || equalType(item, Material.IRON_LEGGINGS)
                || equalType(item, Material.LEATHER_LEGGINGS);
    }

    public static boolean elytra(ItemStack item) {
        return equalType(item, Material.ELYTRA);
    }

    public static boolean liquid(ItemStack item) {
        return equalType(item, Material.WATER) || equalType(item, Material.LAVA);
    }

    public static boolean armor(ItemStack item) {
        return elytra(item) || leggings(item) || boots(item) || helmet(item) || chestPlate(item);
    }

    public static boolean repairable(ItemStack item) {
        return sword(item) || armor(item);
    }

}
