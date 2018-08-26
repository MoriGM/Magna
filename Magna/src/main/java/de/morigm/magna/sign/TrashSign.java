package de.morigm.magna.sign;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.morigm.magna.api.sign.SignListener;

public class TrashSign extends SignListener 
{

	@Override
	public boolean onCreate(String[] lines, Player p, Block sign) 
	{
		return testPermission(p, "createtrashsign");
	}

	@Override
	public void onClick(Sign sign, Player player) 
	{
		Inventory inv = Bukkit.createInventory(null, (9 * 6),(ChatColor.RED + "TrashSign"));
		player.openInventory(inv);
	}

}
