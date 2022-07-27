package Tasks;

public class WhatCenturyIs {
    public static void main(String[] args) {
        System.out.println(whatCentury(1900));
    }

    public static String whatCentury(int year) {
        int century;
        if (year % 10 == 0) {
            century = year / 100;
        }
        else {
            century = (int) (year / 100.0) + 1;
        }
        return century +"th";
    }
}
