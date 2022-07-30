package Tasks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageValidator {
    public static void main(String[] args) {
        System.out.println(isAValidMessage("4code13hellocodewars"));
    }

    public static boolean isAValidMessage(String message) {
        Pattern pattern = Pattern.compile("[a-z]+|\\d+");
        Matcher matcher = pattern.matcher(message);
        ArrayList<String> matchesList = new ArrayList<>();
        while (matcher.find()) {
            matchesList.add(matcher.group());
        }
        for (int i = 0; i < matchesList.size() - 1; i += 2) {
            if (Integer.parseInt(matchesList.get(i)) != matchesList.get(i + 1).length()) {
                return false;
            }
        }

        return true;
    }
}
