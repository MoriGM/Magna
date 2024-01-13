package de.morigm.magna.api.censor

import java.util.*

enum class CensorType {
    BAN,
    KICK,
    WARN,
    MUTE,
    DE_OP,
    SPAWN,
    GROUP_KICK,
    GROUP_BAN,
    KILL,
    CLEAR,
    BLIND,
    NORMAL;

    companion object {
        fun isType(s: String): Boolean {
            for (t in entries) if (t.name == s.uppercase(Locale.getDefault())) return true
            return false
        }

        @JvmStatic
        fun getType(s: String): CensorType {
            for (t in entries) if (t.name == s.uppercase(Locale.getDefault())) return t
            return NORMAL
        }
    }
}
