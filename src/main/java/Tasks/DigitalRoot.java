package Tasks;

public class DigitalRoot {
    public static void main(String[] args) {
        System.out.println(digital_root(194));
    }

    public static int digital_root(int n) {
        if ( n / 10 == 0) {
            return n;
        }

        int result = 0;
        while(n != 0) {
            result += n % 10;
            n = n / 10;
        }
        if (result / 10 != 0) {
            result = digital_root(result);
        }
        return result;
    }
}
