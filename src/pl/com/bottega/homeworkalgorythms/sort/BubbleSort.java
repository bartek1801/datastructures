package pl.com.bottega.homeworkalgorythms.sort;

/**
 * Created by bartek on 10.07.2017.
 */
public class BubbleSort {

    public static void sort(long[] list, int sortKind) {
        //sortowanie tablicy wejsciowej bez tworzenia nowej
        for (int k = 1; k < list.length; k++) {
            for (int i = 0; i < list.length - k; i++) {
                switch (sortKind) {
                    case 1:
                        ascending(list, i);
                        break;
                    case 2:
                        descending(list, i);
                        break;
                    default:
                        System.out.println("wybierz 1 lub 2");
                }
            }
        }
    }

    public static long[] sortChoice(long[] newTable2, SortType sortType) {
        //metoda sortowania prz ztworzeniu nowej tablicy i z wyborem: rosnąco (1) lub malejąco(2)
        for (int k = 1; k < newTable2.length; k++) {
            for (int i = 0; i < newTable2.length - k; i++) {
                switch (sortType) {
                    case ASC:
                        ascending(newTable2, i);
                        break;
                    case DESC:
                        descending(newTable2, i);
                        break;
                }
            }
        }
        return newTable2;
    }

    private static void descending(long[] data, int iterator) {
        if (data[iterator] < data[iterator + 1]) {
            long temporaryItem = data[iterator + 1];
            data[iterator + 1] = data[iterator];
            data[iterator] = temporaryItem;
        }
    }


    public static void ascending(long[] data, int iterator) {
        if (data[iterator] > data[iterator + 1]) {
            long temporaryItem = data[iterator + 1];
            data[iterator + 1] = data[iterator];
            data[iterator] = temporaryItem;
        }

    }

    public static void sort(long[] list) {
        //sortowanie tablicy wejsciowej bez tworzenia nowej
        for (int k = 1; k < list.length; k++) {
            for (int i = 0; i < list.length - k; i++) {
              descending(list, i);
            }
        }
    }

}
