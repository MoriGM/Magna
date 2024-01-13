package de.morigm.magna.api.events

import de.morigm.magna.api.censor.CensorType
import lombok.Getter
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerBlockedWordUsedEvent(
    @field:Getter private val player: Player,
    @field:Getter private val word: String,
    @field:Getter private val censorType: CensorType
) : Event() {
    override fun getHandlers(): HandlerList {
        return HANDLERS
    }

    companion object {
        private val HANDLERS = HandlerList()
    }
}
