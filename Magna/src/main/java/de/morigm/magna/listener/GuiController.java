package de.morigm.magna.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.gui.Gui;
import de.morigm.magna.api.helper.ListenerHelper;
import de.morigm.magna.stuff.MagnaStuff;

public class GuiController extends ListenerHelper {

	@EventHandler
	public void on(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player && e.getInventory().getType() == InventoryType.CHEST) {
			Player p = (Player) e.getWhoClicked();
			Gui gui;
			if ((gui = Magna.getUser(p).getGui()) != null) {
				if (!gui.getName().isEmpty())
					if (!e.getView().getTitle().equals(gui.getName()))
						return;
				if ((gui.getSize() != e.getInventory().getSize())
						|| !gui.getInventory().getHolder().equals(e.getInventory().getHolder()))
					return;

				e.setCancelled(true);

				if (e.getRawSlot() != e.getSlot())
					return;

				if (!gui.getPermission().isEmpty())
					if (!p.hasPermission(gui.getPermission()))
						return;

				gui.registerClick(e.getSlot());

			}
		}
	}

	@EventHandler
	public void on(InventoryCloseEvent e) {
		if (e.getPlayer() instanceof Player && e.getInventory() instanceof InventoryView) {
			Player p = (Player) e.getPlayer();
			Gui gui;

			InventoryView invv = (InventoryView) e.getInventory();
			if ((gui = Magna.getUser(p).getGui()) != null) {
				if (!gui.getName().isEmpty())
					if (!invv.getTitle().equals(gui.getName()))
						return;
				if ((gui.getSize() != e.getInventory().getSize())
						|| !gui.getInventory().getHolder().equals(e.getInventory().getHolder()))
					return;
				MagnaStuff.getGuis().remove(e.getPlayer());
			}
		}
	}

}
