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

import java.util.Objects;

public class SignManipulator extends Listener {

    public static final String prefix = ChatColor.GRAY + "[" + ChatColor.BLUE;
    public static final String suffix = ChatColor.GRAY + "]";

    @EventHandler
    public void on(SignChangeEvent e) {
        if (e.lines().isEmpty()) {
            return;
        }

        String firstLine = Objects.requireNonNull(e.line(0)).toString();
        if (firstLine.startsWith("[") && firstLine.endsWith("]") && firstLine.length() >= 3) {
            String name = firstLine.substring(1, (firstLine.length() - 1));
            if (Magna.getSignManager().contains(name)) {
                SignListener sl = Magna.getSignManager().find(name);
                if (e.getPlayer().hasPermission(getPermission("signcreate") + "." + name)) {
                    String[] lines = e.lines().stream().map(Component::toString).toArray(String[]::new);
                    boolean b = sl.onCreate(lines, e.getPlayer(), e.getBlock());
                    if (b) {
                        e.line(0, Component.text(prefix + name + suffix));
                    }
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
                    SignListener sl = Magna.getSignManager().find(name);
                    if (sl != null && e.getPlayer().hasPermission(getPermission("signclick") + "." + name))
                        sl.onClick(sign, e.getPlayer());
                }
            }
    }

}
