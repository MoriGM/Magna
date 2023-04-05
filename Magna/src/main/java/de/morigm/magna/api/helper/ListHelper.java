package de.morigm.magna.api.helper;

import java.util.Arrays;
import java.util.List;

public class ListHelper {

    @SafeVarargs
    public static <T> boolean isInArray(T in, T... ts) {
        for (T t : ts) {
            if (t.equals(in)) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> split(T[] t, int i) {
        if (i > t.length) {
            return Arrays.asList(t);
        }
        return Arrays.asList(t).subList(i, t.length);
    }

}
