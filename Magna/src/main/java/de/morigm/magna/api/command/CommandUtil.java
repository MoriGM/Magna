package de.morigm.magna.api.command;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class CommandUtil 
{
	
	@Getter private List<String> commandsName = new ArrayList<>();
	@Getter private List<String> translations = new ArrayList<>();
	@Getter private List<String> permissions = new ArrayList<>();
	
	public void registerCommandName(String s)
	{
		if(!commandsName.contains(s))
			commandsName.add(s);
	}
	
	public void registerPermission(String s)
	{
		if(!permissions.contains(s))
			permissions.add(s);
	}
	
	public void registerTranslation(String s)
	{
		if(!translations.contains(s))
			translations.add(s);
	}
	

}
