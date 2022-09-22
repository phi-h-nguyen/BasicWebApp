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

    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; ++i) {
        // condition for nonprime number
        if (num % i == 0) {
            return true;
        }
        }
        return false;
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
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            String[] splited = query.split("[\\s+,]");
            int max = 0;

            for (String s : splited) {
                if (isNumeric(s)) {
                    max = Integer.max(max, Integer.parseInt(s));
                }
            }
            return Integer.toString(max);
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("multplied")) {
            String[] splited = query.split("[\\s+,]");
            int mult = 1;

            for (String s : splited) {
                if (isNumeric(s)) {
                    mult *= Integer.parseInt(s);
                }
            }
            return Integer.toString(mult);
        }
        if (query.toLowerCase().contains("which of the following numbers are prime")) {
            String[] splited = query.split("[\\s+,]");

            for (String s : splited) {
                if (isNumeric(s)) {
                    if (isPrime(Integer.parseInt(s))) {
                        return s;
                    }
                }
            }
            return "";
        }
        return "";
    }
}