package Tasks;

import java.util.Arrays;

public class WhereIsMyParent {
    public static void main(String[] args) {
        System.out.println(findChildren("AbbaaBbcCc"));
    }

    static String findChildren(final String text) {
        if (text.length() == 0) {
            return "";
        }

        char[] characters = text.toLowerCase().toCharArray();
        Arrays.sort(characters);
        characters[0] -= 32;
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] != characters[i + 1] && characters[i] + 32 != characters[i + 1]) {
                characters[i + 1] -= 32;
            }
        }
        return new String(characters);
    }

}
