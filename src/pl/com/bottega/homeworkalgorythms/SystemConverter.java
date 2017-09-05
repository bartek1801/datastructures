package pl.com.bottega.homeworkalgorythms;

/**
 * Created by bartek on 05.08.2017.
 */
public class SystemConverter {

    public static void main(String[] args) {
        int n = 40;
        int k = 2;

//        System.out.println(convert(40, 2));
//        System.out.println(convert(40, 8));
//        System.out.println(convert(40, 16));
//        System.out.println(convert(40, 10));
//        System.out.println(convert(15, 16));
//        System.out.println(convert(15, 1));
        System.out.println(convertToDecimal("10110", 2));
        System.out.println(convertToDecimal("1011", 2));
        System.out.println(convertToDecimal("AA", 16));


    }
    public static String convert(int n, int k){
        if (k > 36 || k <= 0 || n < 0)
            throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();

        if (k == 1){
            for (int i = 0; i < n ; i++){
                sb.append('1');
            }
        }
        else {
            while (n > 0) {
                int mod = n % k;
                String digit;
                if (mod < 10) {
                    digit = String.valueOf(mod);
                    sb.insert(0, digit);
                }
                else {
                    digit = String.valueOf((char) 'A' + mod - 10);
                    sb.append(digit);
                }
                n /= k;
            }
        }

        return sb.toString();
    }

    public static int convertToDecimal(String digits, int k){

        char[] charDigits = digits.toCharArray();
        int result = 0;
        int power = 1;
        for (int i = 0; i < charDigits.length; i++){
            char digit = charDigits[charDigits.length - i - 1];
            int digitDecimal = toDecimal(digit, k); // można użyc tego Character.getNumericValue(digit);
            result += digitDecimal * power;
            power *= k;
        }
        return result;

    }

    private static int toDecimal(char digit, int k) {
        int decimalDigit;

        if (digit >= '0' && digit <= '9')
            decimalDigit = digit - '0';
        else if (digit >= 'A' && digit <= 'Z')
            decimalDigit = digit - 'A';
        else
            throw new IllegalArgumentException();
        return decimalDigit;
    }

}
