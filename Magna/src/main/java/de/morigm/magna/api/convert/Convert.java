package de.morigm.magna.api.convert;

public class Convert 
{
	
	public static boolean isInteger(String s)
	{
		for(char c : s.toCharArray())
			if(c < '0' && c > '9')
				return false;
				
		return true;
	}
	
	public static boolean isBoolean(String s)
	{
		if(s.equals("false") || s.equals("true"))
			return true;
		return false;
	}

}
