package pl.com.bottega.homeworkalgorythms;

import java.util.Scanner;

/**
 * Created by bartek on 16.07.2017.
 */
public class DigitsSumApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę ");
        int number = scanner.nextInt();

        System.out.println("Suma cyfr liczby " + number + " wynosi: " + digitsSum(number));

    }

    public static int digitsSum(int n){
        int sum = 0;
        n = Math.abs(n);

        while (n > 0){
            sum += n%10;
            n /= 10; // n = n/10;
        }

        return sum;
    }

}
