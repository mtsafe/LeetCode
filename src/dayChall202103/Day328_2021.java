package dayChall202103;

import java.util.HashMap;

/*
Z-eorz
W-otw
X-isx
S-eensv
V-eifv
F-foru
O-eno
R-eehrt
G-eghit
E-einn
 */
class SolutionDay328 {
    public HashMap<Character, Integer> string2Hash(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (hash.containsKey(ch))
                hash.replace(ch, hash.get(ch) + 1);
            else
                hash.put(ch, 1);
        }
        return hash;
    }

    public int take(HashMap<Character, Integer> hash, char ch, String s) {
        if (!hash.containsKey(ch)) return 0;
        int cnt = hash.get(ch);
        int amt;
        for (char c : s.toCharArray()) {
            amt = hash.get(c);
            if (amt == cnt)
                hash.remove(c);
            else
                hash.replace(c, hash.get(c) - cnt);
        }
        return cnt;
    }

    public String digits2String(int[] dig) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < dig[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public String originalDigits(String s) {
        HashMap<Character, Integer> hash = string2Hash(s);
        int[] digits = new int[10];
        digits[0] = take(hash, 'z', "zero");
        digits[2] = take(hash, 'w', "two");
        digits[6] = take(hash, 'x', "six");
        digits[7] = take(hash, 's', "seven");
        digits[5] = take(hash, 'v', "five");
        digits[4] = take(hash, 'f', "four");
        digits[1] = take(hash, 'o', "one");
        digits[3] = take(hash, 'r', "three");
        digits[8] = take(hash, 'g', "eight");
        digits[9] = take(hash, 'e', "nine");
        return digits2String(digits);
    }
}

public class Day328_2021 {
    public static void main(String[] args) {
        SolutionDay328 solution = new SolutionDay328();
        String input;
        String result;

        // Example 1
        input = "owoztneoer";
        result = solution.originalDigits(input);
        System.out.println("012 == " + result);

        // Example 2
        input = "fviefuro";
        result = solution.originalDigits(input);
        System.out.println("45 == " + result);
    }
}
