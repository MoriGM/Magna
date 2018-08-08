package de.morigm.magna.api.censor;

public class BlackWord 
{
	
	public BlackWord(String word,String permission,CensorType type) 
	{
		this.word = word;
		this.permission = permission;
		this.type = type;
	}
	
	public final String word,permission;
	public final CensorType type;

}
