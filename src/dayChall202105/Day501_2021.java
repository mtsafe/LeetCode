package dayChall202105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//  6 / 9 test cases passed.

public class Day501_2021 {
    static class WordFilter {
        String[] dict;
        HashMap<Character, Integer> dictHash;
        HashMap<String, Integer> wordsHash;

        HashMap<Character, Integer> buildDictHash(List<String> list) {
            HashMap<Character, Integer> hash = new HashMap<>();
            if (list == null) return hash;
            hash.put('#', list.get(0).charAt(0) == '#' ? 0 : -1);
            for (char ch = 'a'; ch <= 'z'; ch++)
                hash.put(ch, -1);
            char prev = '#', next;
            for (int i = 0; i < list.size(); i++) {
                next = list.get(i).charAt(0);
                if (prev != next) {
                    hash.replace(next, i);
                    prev = next;
                }
            }
            return hash;
        }

        public WordFilter(String[] words) {
            if (words == null) return;
            wordsHash = new HashMap<>();
            List<String> list = new ArrayList<>();
            StringBuilder sb;
            int wordIndex = 0;
            for (String word : words) {
                wordsHash.put(word, wordIndex++);
                sb = new StringBuilder("#" + word);
                list.add(sb.toString());
                for (int i = word.length() - 1; i >= 0; i--) {
                    sb.insert(0, word.charAt(i));
                    list.add(sb.toString());
                }
            }
            Collections.sort(list);
            this.dict = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                this.dict[i] = list.get(i);
            }
            dictHash = buildDictHash(list);
        }

        public int f(String prefix, String suffix) {
            if (prefix == null) prefix = "";
            if (suffix == null) suffix = "";
            String pre = suffix + '#' + prefix;
            int preLen = pre.length();
            // find low index
            char ch = pre.charAt(0);
            int first = dictHash.get(ch);
            if (first == -1) return -1;
            // find high index
            char chNext = ch;
            int index = -1;
            while (++chNext <= 'z') {
                index = dictHash.get(chNext);
                if (index != -1)
                    break;
            }
            if (index == -1)
                index = dict.length - 1;
            String dictWord = dict[index];
            if (dictWord.charAt(0) != ch) index--;
            dictWord = dict[index];
            while (dictWord.charAt(0) == ch) {
//                if (pre.equals(dictWord.substring(0,
//                        Math.min(preLen, dictWord.length())))) {
                if (preLen <= dictWord.length() &&
                        pre.equals(dictWord.substring(0, preLen))) {
                    String tmp = dictWord.substring(dictWord.indexOf('#') + 1);
                    return wordsHash.get(tmp);
                }
                index--;
                if (index < first)
                    break;
                dictWord = dict[index];
            }
            return -1;
        }
    }

    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(prefix,suffix);
     */
    public static void main(String[] args) {
        String[] words;
        String prefix, suffix;
        WordFilter solution;
        int param;

        // Example 1
        words = new String[1];
        words[0] = "apple";
        prefix = "a";
        suffix = "e";
        solution = new WordFilter(words);
        param = solution.f(prefix, suffix);
        System.out.println("0 == " + param);

        // Example 2
        words = new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba",
                "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca",
                "ababccabcb", "caccbbcbab", "bccbacbcba"};
        String[][] preSuf = new String[][]{{"bccbacbcba", "a"}, {"ab", "abcaccbcaa"},
                {"a", "aa"}, {"cabaaba", "abaaaa"}, {"cacc", "accbbcbab"},
                {"ccbcab", "bac"}, {"bac", "cba"}, {"ac", "accabaccaa"}, {"bcbb", "aa"},
                {"ccbca", "cbcababac"}};
        solution = new WordFilter(words);
        for (int i = 0; i < 10; i++) {
            param = solution.f(preSuf[i][0], preSuf[i][1]);
            System.out.println("idk == " + param);
        }
    }
}
