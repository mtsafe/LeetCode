package dayChallFeb2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionDay107 {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }
        int listIndex = 0;
        int nextL = list.get(listIndex++);
        int prevL = nextL;
        for (int i = 0; i < s.length(); i++) {
            if (i > nextL && listIndex < list.size()){
                prevL = nextL;
                nextL = list.get(listIndex++);
            }
            result[i] = Math.min(Math.abs(i-prevL), Math.abs(i-nextL));
        }
        return result;
    }
}

public class Day107_2021 {
    public static void main(String[] args) {
        SolutionDay107 solution = new SolutionDay107();
        String inputS;
        char inputC;
        int[] result;

        // Trivial 1
        inputS = "e";
        inputC = 'e';
        result = solution.shortestToChar(inputS, inputC);
        System.out.println("[0] == "+Arrays.toString(result));

        // Example 1
        inputS = "loveleetcode";
        inputC = 'e';
        result = solution.shortestToChar(inputS, inputC);
        System.out.println("[3,2,1,0,1,0,0,1,2,2,1,0] == "+Arrays.toString(result));

        // Example 2
        inputS = "aaab";
        inputC = 'b';
        result = solution.shortestToChar(inputS, inputC);
        System.out.println("[3,2,1,0] == "+Arrays.toString(result));
    }
}
