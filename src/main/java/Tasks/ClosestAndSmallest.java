package Tasks;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClosestAndSmallest {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                closest("239382 162 254765 182 485944 468751 49780 108 54")));
    }
    public static int[][] closest(String strng) {
        String[] strNumbers = strng.split(" ");
        int[] numbers = new int[strNumbers.length];
        int[] weights = new int[strNumbers.length];
        for(int i = 0; i < strNumbers.length; i++) {
            int number = Integer.parseInt(strNumbers[i]);
            numbers[i] = number;
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number = number / 10;
            }
            weights[i] = sum;
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(weights));

        int[] sortWeights = Arrays.copyOf(weights, weights.length);
        int[] sortNumbers = Arrays.copyOf(numbers, numbers.length);

        for (int i = 0; i < sortWeights.length - 1; i++)
        {
            for (int j = 0; j < sortWeights.length - i - 1; j++)
            {
                if (sortWeights[ j ] > sortWeights[ j + 1 ] )
                {
                    int temp = sortWeights[ j ];
                    int tempN = sortNumbers[ j ];

                    sortWeights[ j ] = sortWeights [ j + 1 ];
                    sortWeights[ j + 1 ] = temp;

                    sortNumbers[ j ] = sortNumbers[ j + 1];
                    sortNumbers[ j + 1 ] = tempN;
                }
            }
        }

        System.out.println(Arrays.toString(sortNumbers));
        System.out.println(Arrays.toString(sortWeights));

        int difference = Integer.MAX_VALUE;
        int number1 = 0;
        int number2 = 0;
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < sortWeights.length - 1; i++) {
            int cur = sortWeights[i + 1] - sortWeights[i];
            if(cur < difference) {
                difference = cur;
                number1 = sortNumbers[i];
                number2 = sortNumbers[i+1];
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number1) {
                index1 = i;
            }
            if (numbers[i] == number2) {
                index2 = i;
            }
        }

        System.out.println(difference + " " + number1 + " " + number2);

        int[][] result = new int[2][3];
        result[0][0] = sortWeights[0];
        result[0][1] = index1;
        result[0][2] = number1;

        result[1][0] = sortWeights[1];
        result[1][1] = index2;
        result[1][2] = number2;

        return result;
    }

}
