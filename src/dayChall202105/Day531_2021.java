package dayChall202105;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Search Suggestions System - Incomplete
 *
 * Given an array of strings products and a string searchWord. We want
 * to design a system that suggests at most three product names from
 * products after each character of searchWord is typed. Suggested products
 * should have common prefix with the searchWord. If there are more than
 * three products with a common prefix return the three lexicographically
 * minimums products.
 *
 * Return list of lists of the suggested products after each character
 * of searchWord is typed.
 */

class SolutionDay531 {
    void printStringArrayArray(List<List<String>> listList) {
        if (listList == null) {
            System.out.println("[[]]");
            return;
        }
        System.out.println("[");
        for (List<String> list : listList) {
            System.out.print("[");
            for (String word : list) {
                System.out.print(word + ", ");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    static class TrieS {
        char ch;
        boolean isEndWord;
        final HashMap<Character, TrieS> children = new HashMap<>();

        TrieS(char ch) {
            this.ch = ch;
            isEndWord = false;
        }

        void addString(String s, int first) {
            if (s == null || s.length() <= first) return;
            if (s.length() - 1 == first) {
                isEndWord = true;
                return;
            }
            char nextCh = s.charAt(first);
            TrieS newTrieS;
            if (this.children.containsKey(nextCh)) {
                this.children.get(nextCh).addString(s, first + 1);
            } else {
                newTrieS = new TrieS(nextCh);
                this.children.put(nextCh, newTrieS);
                newTrieS.addString(s, first + 1);
            }
        }

        List<String> matchChar(String s, int first) {
            return null;
        }

        List<String> findStrings(String s) {
            List<String> result = new ArrayList<>();
            if (s == null || s.length() == 0) return result;
            return matchChar(s, 0);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if (products == null || searchWord == null || searchWord.length() == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        TrieS trieS = new TrieS((char) 0);
        for (String product : products) {
            trieS.addString(product, 0);
        }
        String sW;
        for (int i = 1; i <= searchWord.length(); i++) {
            sW = searchWord.substring(0, i);
            result.add(trieS.findStrings(sW));
        }
        return result;
    }
}

public class Day531_2021 {
    public static void main(String[] args) {
        SolutionDay531 solution = new SolutionDay531();
        String[] inputP;
        String inputS;
        List<List<String>> result;

        // Example 1
        inputP = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        inputS = "mouse";
        result = solution.suggestedProducts(inputP, inputS);
        System.out.println("""
                [
                ["mobile","moneypot","monitor"],
                ["mobile","moneypot","monitor"],
                ["mouse","mousepad"],
                ["mouse","mousepad"],
                ["mouse","mousepad"]
                ] ==\s""");
        solution.printStringArrayArray(result);

        // Example 2
        inputP = new String[]{"havana"};
        inputS = "havana";
        result = solution.suggestedProducts(inputP, inputS);
        System.out.println("""
                [
                ["havana"]
                ["havana"]
                ["havana"]
                ["havana"]
                ["havana"]
                ["havana"]
                ] ==\s""");
        solution.printStringArrayArray(result);

        // Example 3
        inputP = new String[]{"bags", "baggage", "banner", "box", "cloths"};
        inputS = "bags";
        result = solution.suggestedProducts(inputP, inputS);
        System.out.println("""
                [
                ["baggage","bags","banner"],
                ["baggage","bags","banner"],
                ["baggage","bags"],
                ["bags"],
                ] ==\s""");
        solution.printStringArrayArray(result);

        // Example 4
        inputP = new String[]{"havana"};
        inputS = "tatiana";
        result = solution.suggestedProducts(inputP, inputS);
        System.out.println("""
                [
                []
                []
                []
                []
                []
                []
                ] ==\s""");
        solution.printStringArrayArray(result);
    }
}
