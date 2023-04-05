package de.morigm.magna.api.command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CommandUtil {

	@Getter
	private final List<String> commandsName = new ArrayList<>();
	@Getter
	private final List<String> translations = new ArrayList<>();
	@Getter
	private final List<String> permissions = new ArrayList<>();

	public void registerCommandName(String s) {
		if (!commandsName.contains(s))
			commandsName.add(s);
	}

	public void registerPermission(String permission) {
		if (!permissions.contains(permission))
			permissions.add(permission);
	}

	public void registerTranslation(String s) {
		if (!translations.contains(s))
			translations.add(s);
	}

}
