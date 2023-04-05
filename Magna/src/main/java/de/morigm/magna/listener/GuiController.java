package de.morigm.magna.listener;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.gui.Gui;
import de.morigm.magna.api.listner.Listener;
import de.morigm.magna.stuff.MagnaStuff;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

public class GuiController extends Listener {

    @EventHandler
    public void on(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p && e.getInventory().getType() == InventoryType.CHEST) {
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
        if (e.getPlayer() instanceof Player p && e.getInventory() instanceof InventoryView invv) {
            Gui gui;

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
