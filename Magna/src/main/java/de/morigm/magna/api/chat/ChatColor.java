package de.morigm.magna.api.chat;

public enum ChatColor {
	BLACK('0', "black"), DARK_BLUE('1', "dark_blue"), DARK_GREEN('2', "dark_green"), DARK_AQUA('3', "dark_aqua"),
	DARK_RED('4', "dark_red"), DARK_PURPLE('5', "dark_purple"), GOLD('6', "gold"), GRAY('7', "gray"),
	DARK_GRAY('8', "dark_gray"), BLUE('9', "blue"), GREEN('a', "green"), AQUA('b', "aqua"), RED('c', "red"),
	LIGHT_PURPLE('d', "light_purple"), YELLOW('e', "yellow"), WHITE('f', "white"), MAGIC('k', "obfuscated"),
	BOLD('l', "bold"), STRIKETHROUGH('m', "strikethrough"), UNDERLINE('n', "underline"), ITALIC('o', "italic"),
	RESET('r', "reset");

	private String color_name;
	private char color_char;
	private char code_char = '§';
	private String to_string;

	private ChatColor(char c, String color_code) {
		this.color_char = c;
		this.color_name = color_code;
		this.to_string = new String(new char[] { code_char, color_char });
	}

	public String getColorName() {
		return color_name;
	}

	public char getColorChar() {
		return color_char;
	}

	@Override
	public String toString() {
		return this.to_string;
	}

}
