package de.morigm.magna.api.helper;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class ListHelper {

	public static <T> boolean isSame(List<T> firstList, List<T> secondList) {
		if (firstList == secondList)
			return true;
		if (firstList.size() != secondList.size())
			return false;
		for (int i = 0; i < firstList.size(); i++)
			if (!firstList.get(i).equals(secondList.get(i)))
				return false;
		return true;
	}

	@SafeVarargs
	public static <T> List<T> createList(@NonNull T... array) {
		List<T> list = new ArrayList<>();
		for (T t : array)
			list.add(t);
		return list;
	}

	public static <T> List<T> createList() {
		return new ArrayList<T>();
	}

	@SafeVarargs
	public static <T> boolean isInArray(T in, T... ts) {
		for (T t : ts)
			if (t.equals(in))
				return true;
		return false;
	}

	public static <T> List<T> split(T[] t, int i) {
		List<T> list = new ArrayList<>();
		if (i > t.length)
			return list;
		for (int x = i; x < t.length; x++)
			list.add(t[x]);
		return list;

	}

}
