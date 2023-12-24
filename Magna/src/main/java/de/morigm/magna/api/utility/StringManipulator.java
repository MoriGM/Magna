package de.morigm.magna.api.utility;

public class StringManipulator {

    public static String stringArrayToString(String[] arr, String split) {
        StringBuilder tmp = new StringBuilder();
        for (String s : arr) {
            tmp.append(s).append(split);
        }
        return tmp.substring(0, (tmp.length() - split.length()));
    }

    public static String stringArrayToString(String[] arr, String split, int count) {
        StringBuilder tmp = new StringBuilder();
        for (int i = count; i < arr.length; i++) {
            tmp.append(arr[i]).append(split);
        }
        return tmp.substring(0, (tmp.length() - split.length()));
    }

    public static String capitalizeFirst(String text) {
        String up = text.toUpperCase();
        String lower = text.toLowerCase();
        return up.charAt(0) + lower.substring(1);
    }

}
