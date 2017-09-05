package pl.com.bottega.homeworkalgorythms.sort;

/**
 * Created by bartek on 10.07.2017.
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        long[] list = {2, 8, 44, 5, 3, 45, 1, 7, 71, 9, 12, 100, 54, 18, 45};

        BubbleSort sortBubble = new BubbleSort();
        long[] newList = sortBubble.sortChoice(list, SortType.ASC);
        for(long item : newList){
            System.out.print(item + " | ");
        }
        System.out.println("");
        sortBubble.sort(list);
        for(long item : list){
            System.out.print(item + " | ");
        }
    }
}
