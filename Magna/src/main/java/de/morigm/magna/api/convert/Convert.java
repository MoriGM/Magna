package de.morigm.magna.api.convert;

public class Convert {

	public static boolean isInteger(String s) {
		for (char c : s.toCharArray())
			if (c < 48 || c > 57)
				return false;

		return true;
	}

	public static boolean isBoolean(String s) {
		if (s.equals("false") || s.equals("true"))
			return true;
		return false;
	}

	public static boolean isFloat(String s) {
		return isDouble(s);
	}

	public static boolean isDouble(String s) {
		boolean dot_used = false;
		for (char c : s.toCharArray()) {
			if (c == '.')
				if (dot_used)
					return false;
				else
					dot_used = true;
			if ((c < '0' || c > '9') && c != '.')
				return false;
		}
		return true;
	}

}
