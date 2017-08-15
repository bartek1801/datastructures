package pl.com.bottega.homeworkalgorythms;

/**
 * Created by bartek on 20.07.2017.
 */
public class TableOfStrings {

    public static void main(String[] args) {

        String[] table = {"first", "second", "third", "forth", "onesgsgs", "w", ""};

        int tmp = table[0].length();

        for (String item : table){
            if (item.length() < tmp)
                tmp = item.length();
        }
        System.out.println(tmp);

    }

}
