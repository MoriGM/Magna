package de.morigm.magna.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import de.morigm.magna.api.censor.CensorType;
import lombok.Getter;

public class PlayerWriteBlockedWordEvent extends Event {

	private final static HandlerList HANDLERS = new HandlerList();
	@Getter
	private Player player;
	@Getter
	private String word;
	@Getter
	private CensorType censorType;

	public PlayerWriteBlockedWordEvent(Player p, String word, CensorType type) {
		this.player = p;
		this.word = word;
		this.censorType = type;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

}
