package pl.com.bottega.homeworkalgorythms;

import java.util.Scanner;

/**
 * Created by bartek on 06.09.2017.
 */
public class Calculator {

    public static double add(double number1, double number2) {
        return number1 + number2;
    }

    public static double sub(double number1, double number2) {
        return number1 - number2;
    }

    public static double multiply(double number1, double numner2) {
        return number1 * numner2;
    }

    public static double division(double number1, double number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("Nie dzielimy przez 0 :(");
        }
        return number1 / number2;
    }

    public static double power(double number1, double number2){
        return Math.pow(number1,number2);
    }

    public static double sqrt(double number1, double number2){
        return Math.pow(number1, 1 / number2);
    }

    public static void main(String[] args) {

        double number1;
        double number2;
        String sign;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("KALKULATOR");
            System.out.println("Dostępne działania: + - * / ^ <>");
            System.out.println("Podaj wyrażenie (np 2 + 2)");
            System.out.println("=============================");
            number1 = scanner.nextDouble();
            sign = scanner.next();
            number2 = scanner.nextDouble();

            System.out.println("------------wynik------------");

            switch (sign) {
                case "+":
                    System.out.println(add(number1, number2));
                    break;
                case "-":
                    System.out.println(sub(number1, number2));
                    break;
                case "*":
                    System.out.println(multiply(number1, number2));
                    break;
                case "/":
                    System.out.println(division(number1, number2));
                    break;
                case "^":
                    System.out.println(power(number1, number2));
                    break;
                case "<>":
                    System.out.println(sqrt(number1, number2));
                    break;
                default:
                    System.out.println("Nie ma takiego działania");

            }
            System.out.println("=============================");
        }

    }

}
