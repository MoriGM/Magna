package de.morigm.magna.stuff;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class MagnaStuff 
{
	static
	{
		msg = new HashMap<>();
	}
	
	
	@Getter private static Map<String,String> msg;
}
