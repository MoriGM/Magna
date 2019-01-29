package de.morigm.magna.api.helper;

public class StringHelper 
{

	public static String StringArrayToString(String[] arr, String split)
	{
		String tmp = "";
		for (String s : arr)
			tmp += s + split;
		tmp = tmp.substring(0, (tmp.length() - split.length()));
		return tmp;
	}
	
	public static String StringArrayToString(String[] arr, String split, int count)
	{
		String tmp = "";
		for (int i = count;i < arr.length;i++)
			tmp += arr[i] + split;
		tmp = tmp.substring(0, (tmp.length() - split.length()));
		return tmp;
	}
	
	public static String toFirstUpAndRemainderLower(String text)
	{
		String up = text.toUpperCase();
		String lower = text.toLowerCase();
		return up.substring(0, 1) + lower.substring(1);
	}
	
	
}
