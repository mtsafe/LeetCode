package dayChall202103;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SolutionDay326 {

    private HashMap<Character, Integer> string2Hash(String str) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (result.containsKey(ch))
                result.replace(ch, result.get(ch) + 1);
            else
                result.put(ch, 1);
        }
        return result;
    }

    private void superHash(HashMap<Character, Integer>sHash, HashMap<Character, Integer>hash) {
        for (Character ch : hash.keySet()) {
            if (!sHash.containsKey(ch)) {
                sHash.put(ch,hash.get(ch));
                continue;
            }
            if (sHash.get(ch) < hash.get(ch))
                sHash.replace(ch, hash.get(ch));
        }
    }

    private boolean isUniversalOver(String aStr, HashMap<Character, Integer> b) {
        HashMap<Character, Integer> a = string2Hash(aStr);
        for (Character ch : b.keySet()) {
            if (!a.containsKey(ch) || b.get(ch) > a.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        // loop Hashmap B into list
        HashMap<Character, Integer> superB = new HashMap<>();
        for (String str : B) {
            superHash(superB, string2Hash(str));
        }
        // Loop to check each A
        List<String> result = new ArrayList<>();
        for (String str : A) {
            if (isUniversalOver(str, superB))
                result.add(str);
        }
        return result;
    }
}

public class Day326_2021 {
    public static void main(String[] args) {
        SolutionDay326 solution = new SolutionDay326();
        String[] inputA, inputB;
        List<String> result;

        // Example 1
        inputA = new String[]{"amazon","apple","facebook","google","leetcode"};
        inputB = new String[]{"e","o"};
        result = solution.wordSubsets(inputA, inputB);
        System.out.println("[facebook,google,leetcode] == " + result);

        // Example 2
        inputA = new String[]{"amazon","apple","facebook","google","leetcode"};
        inputB = new String[]{"l","e"};
        result = solution.wordSubsets(inputA, inputB);
        System.out.println("[apple,google,leetcode] == " + result);

        // Example 3
        inputA = new String[]{"amazon","apple","facebook","google","leetcode"};
        inputB = new String[]{"e","oo"};
        result = solution.wordSubsets(inputA, inputB);
        System.out.println("[facebook,google] == " + result);

        // Example 4
        inputA = new String[]{"amazon","apple","facebook","google","leetcode"};
        inputB = new String[]{"lo","eo"};
        result = solution.wordSubsets(inputA, inputB);
        System.out.println("[google,leetcode] == " + result);

        // Example 5
        inputA = new String[]{"amazon","apple","facebook","google","leetcode"};
        inputB = new String[]{"ec","oc","ceo"};
        result = solution.wordSubsets(inputA, inputB);
        System.out.println("[facebook,leetcode] == " + result);
    }
}
