package de.morigm.magna.api.helper;

public class StringHelper 
{

	public static String StringArrayToString(String[] arr,String split)
	{
		String tmp = "";
		for(String s : arr)
			tmp += s + split;
		tmp = tmp.substring(0, (tmp.length() - split.length()));
		return tmp;
	}
	
	
}
