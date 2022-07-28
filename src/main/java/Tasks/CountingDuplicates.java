package Tasks;

import java.util.HashSet;

public class CountingDuplicates {

    public static void main(String[] args) {
        System.out.println(duplicateCount("aA11"));
    }

    public static int duplicateCount(String text) {
        HashSet<Character> duplicates = new HashSet<>();
        char[] characters = text.toLowerCase().toCharArray();
        for (int i = 0; i < characters.length - 1; i++) {
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    duplicates.add(characters[i]);
                }
            }
        }

        return duplicates.size();
    }
}
