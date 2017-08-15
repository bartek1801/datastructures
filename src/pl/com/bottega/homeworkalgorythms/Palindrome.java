package pl.com.bottega.homeworkalgorythms;

import java.util.Scanner;

/**
 * Created by bartek on 20.07.2017.
 */
public class Palindrome {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj jakis napis");
            String text = scanner.nextLine();
            System.out.println(isPalindrome(text));
        }
    }

    public static boolean isPalindrome(String text){
        int compare = 0;
        int index = text.length();
        while (compare < text.length()/2){
            if (text.charAt(compare) == text.charAt(index - 1)) {
                compare++;
                index--;
            }
            else return false;
        }
        return true;
    }
}
