package dayChallJan2021;

import java.util.HashMap;

// O(n)
public class Day007_2021 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> hash = new HashMap();
        char ch;
        int first = 0;
        int last;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (hash.containsKey(ch)) {
                last = hash.get(ch);
                hash.replace(ch, i);
                for (; first < last; first++) {
                    hash.remove(s.charAt(first));
                }
                first++;
            } else {
                hash.put(ch, i);
            }
            maxLen = Math.max(maxLen, hash.size());
        }
        return maxLen;
    }
}