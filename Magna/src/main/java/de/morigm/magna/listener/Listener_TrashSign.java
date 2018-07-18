package de.morigm.magna.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_TrashSign implements ListenerHelper
{
	
	@EventHandler
	public void on(SignChangeEvent e)
	{
		if(e.getPlayer().hasPermission(getPermission("createtrashsign")))
			if(e.getLine(0) != null && !e.getLine(0).isEmpty())
				if(e.getLine(0).equals("[Trash]") || e.getLine(0).equals("[trash]"))
				{
					e.setLine(0,ChatColor.GRAY + "[" + ChatColor.BLUE + "Trash" + ChatColor.GRAY +"]");
				}
	}
	
	
	@EventHandler
	public void on(PlayerInteractEvent e)
	{
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getPlayer().hasPermission(getPermission("trashsign")))
			if(e.getClickedBlock().getType().equals(Material.SIGN_POST) || e.getClickedBlock().getType().equals(Material.WALL_SIGN))
			{
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(0) != null && !sign.getLine(0).isEmpty())
					if(sign.getLine(0).equals(ChatColor.GRAY + "[" + ChatColor.BLUE + "Trash" + ChatColor.GRAY +"]"))
					{
						Inventory inv = Bukkit.createInventory(null, (9 * 6),(ChatColor.RED + "TrashSign"));
						e.getPlayer().openInventory(inv);
					}
			}
	}

}
