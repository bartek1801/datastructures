package pl.com.bottega.homeworkalgorythms;

import java.util.Scanner;

/**
 * Created by bartek on 03.09.2017.
 */
public class PA05_POT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę przypadków do rozważenia");
        int count = scanner.nextInt();
        for (int i = 1; i <= count; i++) {
            System.out.println("Podaj podstawę i wykładnik");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int power = a;

            for (int j = 1; j < b; j++) {
                power *= a;
            }
            System.out.println(power % 10);
        }
    }
}
