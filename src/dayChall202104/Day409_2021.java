package dayChall202104;

import java.util.HashMap;

class SolutionDay409 {
    HashMap<Character, Character> hashOrder(String order) {
        HashMap<Character, Character> hash = new HashMap<>();
        char[] chars = order.toCharArray();
        char ch = 'a';
        for (int i = 0; i < chars.length; i++, ch++) {
            hash.put(chars[i], ch);
        }
        return hash;
    }

    private String decode(String s, HashMap<Character, Character> hash) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(hash.get(aChar));
        }
        return sb.toString();
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Character> hash = hashOrder(order);
        String s1, s2;
        s1 = decode(words[0], hash);
        for (int i = 1; i < words.length; i++) {
            s2 = decode(words[i], hash);
            if (s1.compareTo(s2) > 0) return false;
            s1 = s2;
        }
        return true;
    }
}

public class Day409_2021 {
    public static void main(String[] args) {
        SolutionDay409 solution = new SolutionDay409();
        String[] inputWords;
        String inputOrder;
        boolean result;

        // Example 1
        inputWords = new String[]{"hello", "leetcode"};
        inputOrder = "hlabcdefgijkmnopqrstuvwxyz";
        result = solution.isAlienSorted(inputWords, inputOrder);
        System.out.println("true == " + result);

        // Example 2
        inputWords = new String[]{"word", "world", "row"};
        inputOrder = "worldabcefghijkmnpqstuvxyz";
        result = solution.isAlienSorted(inputWords, inputOrder);
        System.out.println("false == " + result);

        // Example 3
        inputWords = new String[]{"apple", "app"};
        inputOrder = "abcdefghijklmnopqrstuvwxyz";
        result = solution.isAlienSorted(inputWords, inputOrder);
        System.out.println("false == " + result);

        // Test Case 1
        inputWords = new String[]{"zirqhpfscx", "zrmvtxgelh", "vokopzrtc",
                "nugfyso", "rzdmvyf", "vhvqzkfqis", "dvbkppw", "ttfwryy",
                "dodpbbkp", "akycwwcdog"};
        inputOrder = "khjzlicrmunogwbpqdetasyfvx";
        result = solution.isAlienSorted(inputWords, inputOrder);
        System.out.println("false == " + result);
    }
}
