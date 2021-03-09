package dayChallMar2021;

class SolutionDay308 {
    private boolean isPalindrome(String s, int start, int stop) {
        if (s == null) return false;
        char[] chars = s.toCharArray();
        for (int i = start, j = stop; i < j; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

    class Distribution {
        int[] d;

        Distribution(int fill, int divisions) {
            d = new int[divisions];
            d[0] = fill - divisions + 1;
            for (int i = 1; i < fill - divisions + 1; i++){i++} // IDK
            for (int i = 1; i < divisions; i++) {
                d[i] = 1;
            }
        }

        int shift() {return 0;} //IDK
    }

    public boolean isInSteps(String s, int steps) {
        if (s == null || s.length() < steps) return false;
        if (s.length() == steps) return true;
        Distribution dist = new Distribution(s.length(), steps);
    }

    public int removePalindromeSub(String s) {
        if (s == null) return 0;
        int minSteps;
        for (minSteps = 0; minSteps < s.length(); minSteps++) {
            if (isInSteps(s, minSteps))
                return minSteps;
        }
        return minSteps;
    }
}

public class Day308_2021 {
    public static void main(String[] args) {
        SolutionDay308 solution = new SolutionDay308();
        String input;
        int result;

        // Example 1
        input = "ababa";
        result = solution.removePalindromeSub(input);
        System.out.println("1 == " + result);

        // Example 2
        input = "abb";
        result = solution.removePalindromeSub(input);
        System.out.println("2 == " + result);

        // Example 3
        input = "baabb";
        result = solution.removePalindromeSub(input);
        System.out.println("2 == " + result);

        // Example 4
        input = "";
        result = solution.removePalindromeSub(input);
        System.out.println("0 == " + result);
    }
}
