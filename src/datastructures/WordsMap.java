package datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by bartek on 19.08.2017.
 */
public class WordsMap {

    public static Map<String, List<Integer>> mapOfString(String text){
        Map<String, List<Integer>> map = new HashMap<>();
        text = text + " ";
        int wordStartIndex = -1;
        for (int index = 0; index < text.length(); index++){
            char c = text.charAt(index);
            if (Character.isWhitespace(c) && wordStartIndex != -1){
                if (wordStartIndex != -1) {
                    String word = text.substring(wordStartIndex, index);
                    putWord(map, word, wordStartIndex);
                    wordStartIndex = -1;
                }
            }
            else if (wordStartIndex == -1)
                wordStartIndex = index;
        }
        return map;
    }


    public static Map<String, List<Integer>> wordsMapV3(String text) {
        Map<String, List<Integer>> map = new HashMap<>();
        int wordStartIndex = -1;
        text = text + ' ';
        for (int index = 0; index < text.length(); index++) {
            char c = text.charAt(index);
            if (Character.isWhitespace(c)) {
                if (wordStartIndex != -1) {
                    String word = text.substring(wordStartIndex, index);
                    putWord(map, word, wordStartIndex);
                    wordStartIndex = -1;
                }
            } else if (wordStartIndex == -1)
                wordStartIndex = index;
        }
        return map;
    }


    public static Map<String, List<Integer>> mapOfStringV2(String text){
        String[] words = text.split(" ");
        Map<String, List<Integer>> map = new HashMap<>();
        int wordIndex = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordIndex = text.indexOf(word, wordIndex);
                putWord(map, word, wordIndex);
                wordIndex += 1;
            }
        }
        return map;
    }


    private static void putWord(Map<String, List<Integer>> map, String word, int index) {
        List<Integer> currnetIndexes = map.get(word);
        if (currnetIndexes == null) {
            currnetIndexes = new LinkedList<>();
            map.put(word, currnetIndexes);
        }
        currnetIndexes.add(index);
    }

    public static void main(String[] args) {

        System.out.println(mapOfString("  ala ma   kota ala"));
        System.out.println(mapOfString("ala ma kota ala"));

        System.out.println("===========================");


        System.out.println(mapOfStringV2("  ala ma   kota ala"));
        System.out.println(mapOfStringV2("ala ma kota ala"));
        System.out.println(mapOfStringV2("aa aaaaa  aaaa    aaa aa a a"));
        System.out.println(mapOfStringV2("kotkot kot kota kotem, kotem       kotem kot"));

    }


}
