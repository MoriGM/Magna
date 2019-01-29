package de.morigm.magna.api.language;

import lombok.Getter;

public class TextStruct 
{
	
	@Getter private final String Old, New;

	public TextStruct(String Old, String New)
	{
		this.Old = Old;
		this.New = New;
	}

}
