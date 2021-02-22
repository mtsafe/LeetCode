package dayChallFeb2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class SolutionDay122 {
    boolean wordIn(String word, String s) {
        if (word == null || s == null)
            return false;
        char[] chW = word.toCharArray();
        char[] chS = s.toCharArray();
        int index = 0;
        for (Character letter : chS) {
            if (letter.equals(chW[index])) {
                if (index == chW.length - 1)
                    return true;
                else
                    index++;
            }
        }
        return false;
    }

    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null)
            return "";
        List<Integer> sizeList = new ArrayList<>();
        HashMap<Integer, String> hash = new HashMap<>();
        int strLen;
        int maxLen = s.length();
        for (String word : d) {
            strLen = word.length();
            if (strLen > maxLen || !wordIn(word, s))
                continue;
            if (hash.containsKey(strLen)) {
                if (word.compareTo(hash.get(strLen)) < 0)
                    hash.replace(strLen, word);
            } else {
                sizeList.add(strLen);
                hash.put(strLen, word);
            }
        }
        Collections.sort(sizeList);
        Collections.reverse(sizeList);
        for (int size : sizeList) {
            if (wordIn(hash.get(size), s))
                return hash.get(size);
        }
        return "";
    }
}

public class Day122_2021 {
    public static void main(String[] args) {
        SolutionDay122 solution = new SolutionDay122();
        String inputS;
        List<String> inputD;
        String result;

        // Example 1
        inputS = "abpcplea";
        inputD = new ArrayList<>() {
        };
        inputD.add("ale");
        inputD.add("apple");
        inputD.add("monkey");
        inputD.add("plea");
        result = solution.findLongestWord(inputS, inputD);
        System.out.println("apple == " + result);

        // Example 2
        inputS = "abpcplea";
        inputD = new ArrayList<>() {
        };
        inputD.add("a");
        inputD.add("b");
        inputD.add("c");
        result = solution.findLongestWord(inputS, inputD);
        System.out.println("a == " + result);

        // Testcase 1
        inputS = "aewfafwafjlwajflwajflwafj";
        inputD = new ArrayList<>() {
        };
        inputD.add("apple");
        inputD.add("ewaf");
        inputD.add("awefawfwaf");
        inputD.add("awef");
        inputD.add("awefe");
        inputD.add("ewafeffewafewf");
        result = solution.findLongestWord(inputS, inputD);
        System.out.println("ewaf == " + result);
    }
}
