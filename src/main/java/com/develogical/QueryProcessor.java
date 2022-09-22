package com.develogical;

import java.util.Arrays;


public class QueryProcessor {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("17313")) {
            return "totally my fav class!";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "someone";
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            String[] splited = query.split("\\s+");
            int sum = 0;

            for (String s : splited) {
                if (isNumeric(s)) {
                    sum += Integer.parseInt(s);
                }
            }
            return Integer.toString(sum);
        }
        return "";
    }
}
