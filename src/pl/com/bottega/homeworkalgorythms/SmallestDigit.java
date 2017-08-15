package pl.com.bottega.homeworkalgorythms;

import java.util.Scanner;

/**
 * Created by bartek on 20.07.2017.
 */
public class SmallestDigit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę");
        int number = scanner.nextInt();

        int digit1;
        int digit2 = 9;

        while (number > 0){
            digit1 = number % 10;
            if (digit1 < digit2)
                digit2 = digit1;
            number /= 10;
        }
        System.out.println(digit2);
    }
}
