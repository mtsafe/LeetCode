package dayChallApr2021;

import java.util.Arrays;

class SolutionDay416 {
    public String removeDuplicates(String s, int k) {
        if (s.isEmpty() || k == 0) return s;
        StringBuilder sb;
        char[] chars = s.toCharArray();
        boolean isReduced = true;
        while (isReduced) {
            isReduced = false;
            sb = new StringBuilder();
            for (int end = 1, start = 0; end <= chars.length; end++) {
                if (chars[start] == chars[end - 1]) {
                    if (end - start == k) {
                        start = end;
                        isReduced = true;
                    }
                    continue;
                }
                for (int i = start; i < end; i++){
                    sb.append(chars[i]);
                }
                start = end;
            }
            chars = sb.toString().toCharArray();
        }
        return Arrays.toString(chars);
    }
}

public class Day416_2021 {
    public static void main(String[] args) {
        SolutionDay416 solution = new SolutionDay416();
        String inputS;
        int inputK;
        String result;

        // Trivial 1
        inputS = "aaaa";
        inputK = 1;
        result = solution.removeDuplicates(inputS, inputK);
        System.out.println(" == " + result);

        // Example 1
        inputS = "abcd";
        inputK = 2;
        result = solution.removeDuplicates(inputS, inputK);
        System.out.println("abcd == " + result);

        // Example 2
        inputS = "deeedbbcccbdaa";
        inputK = 3;
        result = solution.removeDuplicates(inputS, inputK);
        System.out.println("aa == " + result);

        // Example 3
        inputS = "pbbcggttciiippooaais";
        inputK = 2;
        result = solution.removeDuplicates(inputS, inputK);
        System.out.println("ps == " + result);
    }
}
