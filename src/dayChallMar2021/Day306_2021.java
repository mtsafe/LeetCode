package dayChallMar2021;

import java.util.ArrayList;
import java.util.List;

class SolutionDay306 {
    private boolean stringInList(String word, List<String> list) {
        if (word == null || list == null) return false;
        for (String str : list) {
            int strL = str.length();
            int wordL = word.length();
            if (strL >= wordL) {
                if (str.substring(strL - wordL, strL).equals(word))
                    return true;
            } else {
                if (word.substring(wordL - strL, wordL).equals(str)) {
                    list.remove(str);
                    list.add(word);
                    return true;
                }
            }
        }
        return false;
    }

    public int minimumLengthEncoding(String[] words) {
        if (words == null) return 0;
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (!stringInList(word, list))
                list.add(word);
        }
        int sum = 0;
        for (String word : list) {
            sum += word.length() + 1;
        }
        return sum;
    }
}

public class Day306_2021 {
    public static void main(String[] args) {
        SolutionDay306 solution = new SolutionDay306();
        String[] input;
        int result;

        // Example 1
        input = new String[]{"time", "me", "bell"};
        result = solution.minimumLengthEncoding(input);
        System.out.println("10 == " + result);

        // Example 2
        input = new String[]{"t"};
        result = solution.minimumLengthEncoding(input);
        System.out.println("2 == " + result);
    }
}
