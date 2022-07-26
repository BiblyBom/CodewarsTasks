package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class JavaInterview {
    public static void main(String[] args) {
        System.out.println(mostFrequency("[1, 2, 3, [5, 5], 6, [7, 9, [10, 11, 9]]]"));
    }

    public static String mostFrequency (String str) {
        String[] numbersStr = str.replaceAll("\\[","")
                              .replaceAll("]", "")
                              .replaceAll(",", "")
                              .split(" ");
        int[] numbersInt = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            try {
                numbersInt[i] = Integer.parseInt(numbersStr[i]);
            }
            catch (NumberFormatException e) {
                numbersInt[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(numbersInt);
        System.out.println(Arrays.toString(numbersInt));

        ArrayList<Integer> mostFreqNumbs = new ArrayList<>();
        int max = 1;
        int current = 1;
        for (int i = 0; i < numbersInt.length - 1; i++) {
            if (Math.abs(numbersInt[i]) < 1_000_000_000) {
                if (numbersInt[i] == numbersInt[i + 1]) {
                    current++;
                }
                else if (current == max) {
                        mostFreqNumbs.add(numbersInt[i]);
                        current = 1;}
                     else if(current > max) {
                        max = current;
                        mostFreqNumbs.clear();
                        mostFreqNumbs.add(numbersInt[i]);
                        current = 1;
                    }
                     else current = 1;
                }
        }
        if(current == max) {
            mostFreqNumbs.add(numbersInt[numbersInt.length - 1]);
        }
        else if(current > max) {
            max = current;
            mostFreqNumbs.clear();
            mostFreqNumbs.add(numbersInt[numbersInt.length - 1]);
            current = 1;
        }
        StringBuilder result = new StringBuilder();
        Collections.sort(mostFreqNumbs);

        Iterator<Integer> integerIterator = mostFreqNumbs.iterator();
        while (integerIterator.hasNext()) {
            result.append(integerIterator.next());
            if (integerIterator.hasNext()) {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
