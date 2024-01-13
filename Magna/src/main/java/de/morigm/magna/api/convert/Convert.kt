package de.morigm.magna.api.convert

object Convert {
    @JvmStatic
    fun isInteger(s: String): Boolean {
        for (c in s.toCharArray()) if (c.code < 48 || c.code > 57) return false

        return true
    }

    @JvmStatic
    fun isBoolean(s: String): Boolean {
        return s == "false" || s == "true"
    }

    @JvmStatic
    fun isDouble(s: String): Boolean {
        var dot_used = false
        for (c in s.toCharArray()) {
            if (c == '.') if (dot_used) return false
            else dot_used = true
            if ((c < '0' || c > '9') && c != '.') return false
        }
        return true
    }
}
