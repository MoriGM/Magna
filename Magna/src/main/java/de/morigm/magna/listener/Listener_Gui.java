package de.morigm.magna.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.gui.Gui;
import de.morigm.magna.api.helper.ListenerHelper;
import de.morigm.magna.stuff.MagnaStuff;

public class Listener_Gui extends ListenerHelper 
{
	
	@EventHandler
	public void on(InventoryClickEvent e)
	{
		if(e.getWhoClicked() instanceof Player)
		{
			Player p = (Player) e.getWhoClicked();
			Gui gui;
			if((gui = Magna.getUser(p).getGui()) != null)
			{
				if(!gui.getName().isEmpty())
					if(!e.getInventory().getTitle().equals(gui.getName()))
						return;
				if(gui.getSize() != e.getInventory().getSize())
					return;
				if(!gui.getInventory().getHolder().equals(e.getInventory().getHolder()))
					return;
				
				e.setCancelled(true);
				
				if(e.getRawSlot() != e.getSlot())
					return;
				
				if(!gui.getPermission().isEmpty())
					if(!p.hasPermission(gui.getPermission()))
						return;
				
				gui.registerClick(e.getSlot());
				
			}
		}
	}
	
	@EventHandler
	public void on(InventoryCloseEvent e)
	{
		if(e.getPlayer() instanceof Player)
		{
			Player p = (Player) e.getPlayer();
			Gui gui;
			if((gui = Magna.getUser(p).getGui()) != null)
			{
				if(!gui.getName().isEmpty())
					if(!e.getInventory().getTitle().equals(gui.getName()))
						return;
				if(gui.getSize() != e.getInventory().getSize())
					return;
				if(!gui.getInventory().getHolder().equals(e.getInventory().getHolder()))
					return;
				MagnaStuff.getGuis().remove(e.getPlayer());
			}
		}
	}

}
