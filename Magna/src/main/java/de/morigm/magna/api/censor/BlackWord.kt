package de.morigm.magna.api.censor

@JvmRecord
data class BlackWord(@JvmField val word: String, @JvmField val permission: String, @JvmField val type: CensorType)
