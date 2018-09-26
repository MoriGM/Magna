package de.morigm.magna.api.helper;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemHelper 
{
	
	public static boolean equalsType(ItemStack item,Material material)
	{
		return item.getType().equals(material);
	}
	
	public static boolean sameItem(ItemStack first,ItemStack second)
	{
		return first.getType().equals(second.getType()) && first.getDurability() == second.getDurability();
	}
	
	public static boolean isSword(ItemStack item)
	{
		return equalsType(item, Material.DIAMOND_SWORD) || equalsType(item, Material.GOLD_SWORD) || equalsType(item, Material.WOOD_SWORD) || equalsType(item, Material.IRON_SWORD) || equalsType(item, Material.STONE_SWORD);
	}
	
	public static boolean isHelmet(ItemStack item)
	{
		return equalsType(item, Material.CHAINMAIL_HELMET) || equalsType(item, Material.DIAMOND_HELMET) || equalsType(item, Material.GOLD_HELMET) || equalsType(item, Material.IRON_HELMET) || equalsType(item, Material.LEATHER_HELMET);
	}
	
	public static boolean isBoots(ItemStack item)
	{
		return equalsType(item, Material.CHAINMAIL_BOOTS) || equalsType(item, Material.DIAMOND_BOOTS) || equalsType(item, Material.GOLD_BOOTS) || equalsType(item, Material.IRON_BOOTS) || equalsType(item, Material.LEATHER_BOOTS);
	}
	
	public static boolean isChectPlate(ItemStack item)
	{
		return equalsType(item, Material.CHAINMAIL_CHESTPLATE) || equalsType(item, Material.DIAMOND_CHESTPLATE) || equalsType(item, Material.GOLD_CHESTPLATE) || equalsType(item, Material.IRON_CHESTPLATE) || equalsType(item, Material.LEATHER_CHESTPLATE);
	}
	
	public static boolean isLeggings(ItemStack item)
	{
		return equalsType(item, Material.CHAINMAIL_LEGGINGS) || equalsType(item, Material.DIAMOND_LEGGINGS) || equalsType(item, Material.GOLD_LEGGINGS) || equalsType(item, Material.IRON_LEGGINGS) || equalsType(item, Material.LEATHER_LEGGINGS);
	}
	
	public static boolean isElytra(ItemStack item)
	{
		return equalsType(item, Material.ELYTRA);
	}
	
	public static boolean isLiquid(ItemStack item)
	{
		return equalsType(item, Material.WATER) || equalsType(item, Material.LAVA) || equalsType(item, Material.STATIONARY_WATER) || equalsType(item, Material.STATIONARY_LAVA);
	}
	
	public static boolean isArmor(ItemStack item)
	{
		return isElytra(item) || isLeggings(item) || isBoots(item) || isHelmet(item) || isChectPlate(item);
	}
	
	public static boolean isRepairable(ItemStack item)
	{
		return isSword(item) || isArmor(item);
	}
	
	
	public static ItemStack getItem(ItemStack item,String text)
	{
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(text);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack getItem(Material m,String text)
	{
		return getItem(new ItemStack(m), text);
	}
	
	public static ItemStack getItem(Material m,short b,String text)
	{
		return getItem(new ItemStack(m, 1, b), text);
	}
	
}
