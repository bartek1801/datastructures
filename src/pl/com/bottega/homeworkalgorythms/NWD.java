package pl.com.bottega.homeworkalgorythms;

import java.util.Scanner;

/**
 * Created by bartek on 02.09.2017.
 */
public class NWD {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println(String.format("Podaj pierwszą liczbę"));
//        int number1 = scanner.nextInt();
//        System.out.println(String.format("Podaj drugą liczbę"));
//        int number2 = scanner.nextInt();

        int n1 = 125;
        int n2 = 100;


        //rozkłądanie na czynniki pierwsze
        //factors(number1);
        euklidesAlgorythm(n1, n2);


    }

    public static void factors(int number){
        int tmp = number;
        int divider = 2;
        while (tmp != 1){
            while (tmp % divider != 0)
                divider++;
            tmp /= divider;
            System.out.println(divider);
        }
    }

    public static void euklidesAlgorythm(int number1, int number2){
        if (number2 > number1) {
            int tmp = number1;
            number1 = number2;
            number2 = tmp;
        }
        while (number1 % number2 != 0) {
            number1 /= number2;
            number1 = number1 / number2;
            System.out.println(number1 + " | " + number2);
        }

    }

}
