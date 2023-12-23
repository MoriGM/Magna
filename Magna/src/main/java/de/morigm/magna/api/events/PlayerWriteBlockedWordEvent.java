package de.morigm.magna.api.events;

import de.morigm.magna.api.censor.CensorType;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerWriteBlockedWordEvent extends Event {

    private final static HandlerList HANDLERS = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private final String word;
    @Getter
    private final CensorType censorType;

    public PlayerWriteBlockedWordEvent(Player p, String word, CensorType type) {
        this.player = p;
        this.word = word;
        this.censorType = type;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

}
