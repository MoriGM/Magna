package de.morigm.magna.api.helper;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class ListHelper 
{
	
	public static <T> boolean isSame(List<T> firstList,List<T> secondList)
	{
		if(firstList == secondList)
			return true;
		if(firstList.size() != secondList.size())
			return false;
		for(int i = 0;i < firstList.size();i++)
			if(!firstList.get(i).equals(secondList.get(i)))
				return false;
		return true;
	}
	
	@SafeVarargs
	public static <T> List<T> createList(@NonNull T ... array)
	{
		List<T> list = new ArrayList<>();
		for(T t : array)
			list.add(t);
		return list;
	}
	
	public static <T> List<T> createList()
	{
		return new ArrayList<T>();
	}

}
