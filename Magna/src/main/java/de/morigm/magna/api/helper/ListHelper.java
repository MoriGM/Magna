package de.morigm.magna.api.helper;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListHelper {

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
		list.addAll(Arrays.asList(t).subList(i, t.length));
		return list;

	}

}
