package dayChall202102;

class SolutionDay124 {

    private static class balParenRetObj {
        int score;
        int endPosition;

        balParenRetObj(int score, int endPosition) {
            this.score = score;
            this.endPosition = endPosition;
        }
    }

    public balParenRetObj scoreOfParenthesesRecurse_1stTry(String S, int index) {
        if (S == null)
            return null;
        System.out.println("Recurse(\"" + S + "\", " + index + ")");
        int sum = 0;
        char[] chars = S.toCharArray();
        balParenRetObj obj;
        int i = index;
        for (int ii = index; i < S.length(); i++) {
            System.out.println("#2 @"+i);
            if (chars[i] == '(') {
                if (chars[i + 1] == '(') {
                    // "(("
                    obj = scoreOfParenthesesRecurse(S, i + 1);
                    System.out.println("sum "+sum+" += " + (2 * obj.score));
                    sum += 2 * obj.score;
                    i = obj.endPosition;
                } else {
                    // "()"
                    System.out.println("sum "+sum+" += " + 1);
                    sum += 1;
                    i++;
                    System.out.println("========= returnA " + sum + " : " + i + " =========");
                    return new balParenRetObj(sum, i);
                }
            } else {
                // ")"
//                if (i + 1 < S.length() && chars[i + 1] != '(')
                System.out.println("========= returnB " + sum + " : " + i + " =========");
                return new balParenRetObj(sum, i);
            }
        }
        System.out.println("========= returnC " + sum + " : " + i + " =========");
        return new balParenRetObj(sum, i);
    }

    public balParenRetObj scoreOfParenthesesRecurse(String S, int index) {
        if (S == null)
            return null;
        int sum = 0;
        char[] chars = S.toCharArray();
        balParenRetObj obj;
        int i = index;
        if (chars[i] != '(')
            return null;
        if (chars[i + 1] == ')') {
            // "()"
            sum += 1;
            i++;
            return new balParenRetObj(sum, i);
        }
        while (chars[i + 1] == '(') {
            // "(("
            obj = scoreOfParenthesesRecurse(S, i + 1);
            sum += 2 * obj.score;
            i = obj.endPosition;
        }
        return new balParenRetObj(sum, ++i);
    }

    public int scoreOfParentheses(String S) {
        if (S == null)
            return 0;
        int score = 0;
        int index = 0;
        int cnt = 0;
        while (index < S.length()) {
            balParenRetObj obj = scoreOfParenthesesRecurse(S, index);
            score += obj.score;
            index = obj.endPosition + 1;
            if (++cnt > 10)
                return score;
        }
        return score;
    }
}

public class Day124_2021 {
    public static void main(String[] args) {
        SolutionDay124 solution = new SolutionDay124();
        String input;
        int result;

        // Test 1
        input = "((((()))))";
        result = solution.scoreOfParentheses(input);
        System.out.println("16 == " + result);

        // Test 2
        input = "()()()()()";
        result = solution.scoreOfParentheses(input);
        System.out.println("5 == " + result);

        // Test 3
        input = "(()()()()())";
        result = solution.scoreOfParentheses(input);
        System.out.println("10 == " + result);

        // Test 4
        input = "(())()()()()";
        result = solution.scoreOfParentheses(input);
        System.out.println("6 == " + result);

        // Test 5
        input = "(()(()))()()()()";
        result = solution.scoreOfParentheses(input);
        System.out.println("10 == " + result);

        // Example 1
        input = "()";
        result = solution.scoreOfParentheses(input);
        System.out.println("1 == " + result);

        // Example 2
        input = "(())";
        result = solution.scoreOfParentheses(input);
        System.out.println("2 == " + result);

        // Example 3
        input = "()()";
        result = solution.scoreOfParentheses(input);
        System.out.println("2 == " + result);

        // Example 4
        input = "(()(()))";
        result = solution.scoreOfParentheses(input);
        System.out.println("6 == " + result);

        // Testcase 1
        input = "(())()";
        result = solution.scoreOfParentheses(input);
        System.out.println("3 == " + result);

    }
}
