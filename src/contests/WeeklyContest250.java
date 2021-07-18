package contests;

import java.util.HashSet;

class SolutionWC250 {
    public int canBeTypedWords(String text, String brokenLetters) {
        if (text == null || brokenLetters == null) return 0;
        HashSet<Character> hash = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) hash.add(ch);
        String[] sA = text.split("\\s+");
        int result = 0;
        int sLen;
        boolean isTypeable;
        for (String s : sA) {
            sLen = s.length();
            isTypeable = true;
            for (int i = 0; i < sLen; i++) {
                if (hash.contains(s.charAt(i))) {
                    isTypeable = false;
                    break;
                }
            }
            if (isTypeable) result++;
        }
        return result;
    }

    public int addRungs(int[] rungs, int dist) {
        if (rungs == null || dist < 1) return 0;
        int cur = 0;
        int result = 0;
        for (int rung : rungs) {
            if (rung - cur > dist) {
                result += (rung - cur) / dist;
                if ((rung - cur) % dist == 0) result--;
            }
            cur = rung;
        }
        return result;
    }

    public long maxPoints(int[][] points) {
        if (points == null) return 0;
        long result = 0;
        long tmp;
        int maxCol=0;
        for (int j = 0; j < points[0].length; j++) {
            tmp = 0;
            for (int i = 0; i < points.length; i++)
                tmp += points[i][j];
            result = Math.max(result, tmp);
        }
        return result;
    }
}

public class WeeklyContest250 {
    public static void main(String[] args) {
        SolutionWC250 solution = new SolutionWC250();
        int[][] inputP;
        long resultL;

        // Example 1
        inputP = new int[][]{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        resultL = solution.maxPoints(inputP);
        System.out.println("9 == " + resultL);

        // Example 2
        inputP = new int[][]{{1, 5}, {2, 3}, {4, 2}};
        resultL = solution.maxPoints(inputP);
        System.out.println("11 == " + resultL);

        /////////////////////////////////////////////
        int[] inputR;
        int inputD;
        int resultI;

        // Example 1
        inputR = new int[]{1, 3, 5, 10};
        inputD = 2;
        resultI = solution.addRungs(inputR, inputD);
        System.out.println("2 == " + resultI);

        // Example 2
        inputR = new int[]{3, 6, 8, 10};
        inputD = 3;
        resultI = solution.addRungs(inputR, inputD);
        System.out.println("0 == " + resultI);

        // Example 3
        inputR = new int[]{3, 4, 6, 7};
        inputD = 2;
        resultI = solution.addRungs(inputR, inputD);
        System.out.println("1 == " + resultI);

        // Example 4
        inputR = new int[]{5};
        inputD = 10;
        resultI = solution.addRungs(inputR, inputD);
        System.out.println("0 == " + resultI);

        // Testcase 1
        inputR = new int[]{3};
        inputD = 1;
        resultI = solution.addRungs(inputR, inputD);
        System.out.println("2 == " + resultI);

        /////////////////////////////////////////////
        String inputT, inputBL;

        // Example 1
        inputT = "hello world";
        inputBL = "ad";
        resultI = solution.canBeTypedWords(inputT, inputBL);
        System.out.println("1 == " + resultI);

        // Example 2
        inputT = "leet code";
        inputBL = "lt";
        resultI = solution.canBeTypedWords(inputT, inputBL);
        System.out.println("1 == " + resultI);

        // Example 3
        inputT = "leet code";
        inputBL = "e";
        resultI = solution.canBeTypedWords(inputT, inputBL);
        System.out.println("0 == " + resultI);
    }
}
