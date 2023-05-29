package de.morigm.magna.listener;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.listner.Listener;
import de.morigm.magna.api.sign.SignListener;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignManipulator extends Listener {

    public static final String prefix = ChatColor.GRAY + "[" + ChatColor.BLUE;
    public static final String suffix = ChatColor.GRAY + "]";

    @EventHandler
    public void on(SignChangeEvent e) {
        Component component = e.line(0);
        if (component == null) {
            return;
        }
        String firstLine = component.toString();
        if (e.getLines()[0] != null && !e.getLines()[0].isEmpty() && e.getLines()[0].startsWith("[")
                && e.getLines()[0].endsWith("]") && e.getLines()[0].length() >= 3) {
            String name = e.getLines()[0].substring(1, (e.getLines()[0].length() - 1));
            SignListener sl = Magna.getSignManager().getSignListener(name);
            if (sl != null)
                if (e.getPlayer().hasPermission(getPermission("signcreate") + "." + name)) {
                    boolean b = sl.onCreate(e.getLines(), e.getPlayer(), e.getBlock());
                    if (b) {
                        e.line(0, Component.text(prefix + name + suffix));
                    }
                }
        }
    }

    @EventHandler
    public void on(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            if (e.getClickedBlock().getState() instanceof Sign sign) {
                String firstLine = sign.line(0).toString();
                if (firstLine.startsWith(prefix) && firstLine.endsWith(suffix) && firstLine.length() >= (prefix.length() + suffix.length() + 1)) {
                    String name = firstLine.substring(prefix.length(), (firstLine.length() - suffix.length()));
                    SignListener sl = Magna.getSignManager().getSignListener(name);
                    if (sl != null && e.getPlayer().hasPermission(getPermission("signclick") + "." + name))
                        sl.onClick(sign, e.getPlayer());
                }
            }
    }

}
