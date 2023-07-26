package de.morigm.magna.api.utility;

public class StringManipulator {

    public static String stringArrayToString(String[] arr, String split) {
        String tmp = "";
        for (String s : arr) {
            tmp += s + split;
        }
        tmp = tmp.substring(0, (tmp.length() - split.length()));
        return tmp;
    }

    public static String stringArrayToString(String[] arr, String split, int count) {
        String tmp = "";
        for (int i = count; i < arr.length; i++) {
            tmp += arr[i] + split;
        }
        tmp = tmp.substring(0, (tmp.length() - split.length()));
        return tmp;
    }

    public static String capitalizeFirst(String text) {
        String up = text.toUpperCase();
        String lower = text.toLowerCase();
        return up.charAt(0) + lower.substring(1);
    }

}
