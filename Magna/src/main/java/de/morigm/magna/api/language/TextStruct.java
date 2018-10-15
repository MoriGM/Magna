package de.morigm.magna.api.language;

import lombok.Getter;

public class TextStruct 
{
	
	@Getter private final String Old;
	@Getter private final String New;

	public TextStruct(String Old,String New)
	{
		this.Old = Old;
		this.New = New;
	}

}
