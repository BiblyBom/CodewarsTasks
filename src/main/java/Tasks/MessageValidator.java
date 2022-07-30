package Tasks;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageValidator {
    public static void main(String[] args) {
        System.out.println(isAValidMessage("5UOiTr"));
    }

    public static boolean isAValidMessage(String message) {
        if (message.equals("") || message.equals("0")) {
            return true;
        }
        if (message.matches("\\s+")) {
            return true;
        }
        Pattern pattern = Pattern.compile("[a-z,A-Z]+|\\d+");
        Matcher matcher = pattern.matcher(message);
        ArrayList<String> matchesList = new ArrayList<>();
        while (matcher.find()) {
            matchesList.add(matcher.group());
        }
        if (matchesList.size() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < matchesList.size() - 1; i += 2) {
            int nextInt = 0;
            try {
                nextInt = Integer.parseInt(matchesList.get(i));
            } catch (NumberFormatException e) {
                return false;
            }
            if (nextInt != matchesList.get(i + 1).length()) {
                return false;
            }
        }

        return true;
    }
}
