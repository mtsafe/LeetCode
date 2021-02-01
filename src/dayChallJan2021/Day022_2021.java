package dayChallJan2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class SolutionDay022 {
    private void loadHash(HashMap<Character, Integer> hash, String word) {
        for (Character ch : word.toCharArray()) {
            if (hash.containsKey(ch))
                hash.put(ch, hash.get(ch) + 1);
            else
                hash.put(ch, 1);
        }
    }

    private boolean isSameLetters(HashMap<Character, Integer> hash1,
                                HashMap<Character, Integer> hash2) {
        if (hash1.size() != hash2.size())
            return false;
        for (Character ch: hash1.keySet()) {
            if (!hash2.containsKey(ch))
                return false;
        }
        return true;
    }

    private boolean isSameFrequencies(HashMap<Character, Integer> hash1,
                                    HashMap<Character, Integer> hash2) {
        ArrayList<Integer> list1 = new ArrayList<>(hash1.values());
        ArrayList<Integer> list2 = new ArrayList<>(hash2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> hash1 = new HashMap<>();
        HashMap<Character, Integer> hash2 = new HashMap<>();
        loadHash(hash1, word1);
        loadHash(hash2, word2);
        return isSameLetters(hash1, hash2) &&
                isSameFrequencies(hash1, hash2);
    }
}

public class Day022_2021 {
    public static void main(String[] args) {
        SolutionDay022 solution = new SolutionDay022();
        boolean result;
        result = solution.closeStrings("abc", "bca");
        System.out.println("true == " + result);
        result = solution.closeStrings("a", "aa");
        System.out.println("false == " + result);
        result = solution.closeStrings("cabbba", "abbccc");
        System.out.println("true == " + result);
        result = solution.closeStrings("cabbba", "aabbss");
        System.out.println("false == " + result);
    }
}
