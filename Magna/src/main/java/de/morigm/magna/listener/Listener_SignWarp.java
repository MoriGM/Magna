package de.morigm.magna.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.morigm.magna.Main;
import de.morigm.magna.api.helper.ListenerHelper;

public class Listener_SignWarp extends ListenerHelper
{
	@EventHandler
	public void on(SignChangeEvent e)
	{
		if(e.getPlayer().hasPermission(getPermission("createwarpsign")))
			if(e.getLine(0) != null && !e.getLine(0).isEmpty() && e.getLine(1) != null && !e.getLine(1).isEmpty())
				if(e.getLine(0).equals("[Warp]") || e.getLine(0).equals("[warp]"))
				{
					e.setLine(0,ChatColor.GRAY + "[" + ChatColor.BLUE + "Warp" + ChatColor.GRAY +"]");
				}
	}
	
	@EventHandler
	public void on(PlayerInteractEvent e)
	{
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getPlayer().hasPermission(getPermission("warpsign")))
			if(e.getClickedBlock().getType().equals(Material.SIGN_POST) || e.getClickedBlock().getType().equals(Material.WALL_SIGN))
			{
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(0) != null && !sign.getLine(0).isEmpty())
					if(sign.getLine(1) != null && !sign.getLine(1).isEmpty())
						if(sign.getLine(0).equals(ChatColor.GRAY + "[" + ChatColor.BLUE + "Warp" + ChatColor.GRAY +"]"))
							if(Main.getInstance().getWarpManager().containsWarp(sign.getLine(1)))
								if(e.getPlayer().hasPermission(Main.getInstance().getWarpManager().getWarp(sign.getLine(1)).permission))
								{
									Location loc = Main.getInstance().getWarpManager().getWarpLocation(sign.getLine(1));
									e.getPlayer().teleport(loc);
								}
			}
	}
}
