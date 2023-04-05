package de.morigm.magna.stuff;

import de.morigm.magna.api.gui.Gui;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagnaStuff {
    @Getter
    private static final Map<String, String> msg;
    @Getter
    private static final List<Player> onlybreaks;
    @Getter
    private static final Map<Player, Gui> guis;

    static {
        msg = new HashMap<>();
        onlybreaks = new ArrayList<>();
        guis = new HashMap<>();
    }
}
