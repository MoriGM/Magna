package de.morigm.magna.api.helper;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemHelper {

	public static boolean equalsType(ItemStack item, Material material) {
		return item.getType().equals(material);
	}

	public static boolean sameItem(ItemStack first, ItemStack second) {
		return first.getType().equals(second.getType()) && ((short) ((Damageable) first.getItemMeta())
				.getDamage()) == ((short) ((Damageable) second.getItemMeta()).getDamage());
	}

	public static boolean isSword(ItemStack item) {
		return equalsType(item, Material.DIAMOND_SWORD) || equalsType(item, Material.GOLDEN_SWORD)
				|| equalsType(item, Material.WOODEN_SWORD) || equalsType(item, Material.IRON_SWORD)
				|| equalsType(item, Material.STONE_SWORD);
	}

	public static boolean isHelmet(ItemStack item) {
		return equalsType(item, Material.CHAINMAIL_HELMET) || equalsType(item, Material.DIAMOND_HELMET)
				|| equalsType(item, Material.GOLDEN_HELMET) || equalsType(item, Material.IRON_HELMET)
				|| equalsType(item, Material.LEATHER_HELMET);
	}

	public static boolean isBoots(ItemStack item) {
		return equalsType(item, Material.CHAINMAIL_BOOTS) || equalsType(item, Material.DIAMOND_BOOTS)
				|| equalsType(item, Material.GOLDEN_BOOTS) || equalsType(item, Material.IRON_BOOTS)
				|| equalsType(item, Material.LEATHER_BOOTS);
	}

	public static boolean isChectPlate(ItemStack item) {
		return equalsType(item, Material.CHAINMAIL_CHESTPLATE) || equalsType(item, Material.DIAMOND_CHESTPLATE)
				|| equalsType(item, Material.GOLDEN_CHESTPLATE) || equalsType(item, Material.IRON_CHESTPLATE)
				|| equalsType(item, Material.LEATHER_CHESTPLATE);
	}

	public static boolean isLeggings(ItemStack item) {
		return equalsType(item, Material.CHAINMAIL_LEGGINGS) || equalsType(item, Material.DIAMOND_LEGGINGS)
				|| equalsType(item, Material.GOLDEN_LEGGINGS) || equalsType(item, Material.IRON_LEGGINGS)
				|| equalsType(item, Material.LEATHER_LEGGINGS);
	}

	public static boolean isElytra(ItemStack item) {
		return equalsType(item, Material.ELYTRA);
	}

	public static boolean isLiquid(ItemStack item) {
		return equalsType(item, Material.WATER) || equalsType(item, Material.LAVA);
	}

	public static boolean isArmor(ItemStack item) {
		return isElytra(item) || isLeggings(item) || isBoots(item) || isHelmet(item) || isChectPlate(item);
	}

	public static boolean isRepairable(ItemStack item) {
		return isSword(item) || isArmor(item);
	}

	public static ItemStack getItem(ItemStack item, String text) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(text);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack getItem(Material m, String text) {
		return getItem(new ItemStack(m), text);
	}

	@SuppressWarnings("deprecation")
	public static ItemStack getItem(Material m, short b, String text) {
		return getItem(new ItemStack(m, 1, b), text);
	}

}
