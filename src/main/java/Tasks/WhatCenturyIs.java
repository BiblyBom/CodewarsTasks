package Tasks;

public class WhatCenturyIs {
    public static void main(String[] args) {
        System.out.println(whatCentury(2890));
    }

    public static String whatCentury(int year) {
        int century;
        if (year % 100 == 0) {
            century = year / 100;
        }
        else {
            century = (int) (year / 100.0) + 1;
        }
        if (century == 11 || century == 12 || century == 13) {
            return century +"th";
        }
        return (century % 10 == 1) ? century +"st" : (century % 10 == 2) ? century +"nd" :
                (century % 10 == 3) ? century +"rd" : century +"th";
    }
}
