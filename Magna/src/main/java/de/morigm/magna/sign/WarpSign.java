package de.morigm.magna.sign;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.sign.SignListener;
import de.morigm.magna.api.warp.Warp;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class WarpSign extends SignListener {

    @Override
    public boolean onCreate(String[] lines, Player p, Block sign) {
        return !lines[1].isEmpty() && Magna.getWarpManager().containsWarp(lines[1]) && testPermission(p, "createwarpsign");
    }

    @Override
    public void onClick(Sign sign, Player player) {
        if (testPermission(player, "warpsign")) {
            Warp warp = Magna.getWarpManager().getWarp(sign.getLine(1));
            if (warp != null)
                if (player.hasPermission(warp.permission))
                    player.teleport(warp.location);
        }
    }

}
