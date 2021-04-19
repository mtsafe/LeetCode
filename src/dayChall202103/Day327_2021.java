package dayChall202103;

class SolutionDay327 {
    private int palindromeCnt(char[] chars, int position) {
        int cnt = 1;
        for (int i = 1; i <= position && chars.length > position + i; i++) {
            if (chars[position - i] != chars[position + i])
                break;
            cnt++;
        }
        for (int i = 1; i - 1 <= position && chars.length > position + i; i++) {
            if (chars[position - i + 1] != chars[position + i])
                break;
            cnt++;
        }
        return cnt;
    }

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++)
            cnt += palindromeCnt(chars, i);
        return cnt;
    }
}

public class Day327_2021 {
    public static void main(String[] args) {
        SolutionDay327 solution = new SolutionDay327();
        String input;
        int result;

        // Example 1
        input = "abc";
        result = solution.countSubstrings(input);
        System.out.println("3 == " + result);

        // Example 2
        input = "aaa";
        result = solution.countSubstrings(input);
        System.out.println("6 == " + result);

        // Test 1
        input = "aaaa";
        result = solution.countSubstrings(input);
        System.out.println("10 == " + result);

        // Test 2
        input = "aaba";
        result = solution.countSubstrings(input);
        System.out.println("6 == " + result);

        // Test 3
        input = "aabaa";
        result = solution.countSubstrings(input);
        System.out.println("9 == " + result);
    }
}
