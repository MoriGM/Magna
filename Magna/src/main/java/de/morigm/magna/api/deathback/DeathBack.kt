package de.morigm.magna.api.deathback

import org.bukkit.Location

@JvmRecord
data class DeathBack(@JvmField val uuid: String, @JvmField val location: Location)
