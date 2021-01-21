package dailyChallenges;

import java.util.Stack;

class SolutionDay020 {
    private boolean isPair(char openChar, char closeChar) {
        return openChar == '(' && closeChar == ')' ||
                openChar == '{' && closeChar == '}' ||
                openChar == '[' && closeChar == ']';
    }

    public boolean isNotPushable(char openChar) {
        return openChar != '(' && openChar != '{' && openChar != '[';
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (stack.size() == 0) {
                if (isNotPushable(ch))
                    return false;
                stack.push(ch);
            } else if (isPair(stack.peek(), ch))
                stack.pop();
            else {
                if (isNotPushable(ch))
                    return false;
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }
}

public class Day020_2021 {
    public static void main(String[] args) {
        SolutionDay020 solution = new SolutionDay020();
        boolean result;
        result = solution.isValid("()");
        System.out.println("true == " + result);
        result = solution.isValid("()[]{}");
        System.out.println("true == " + result);
        result = solution.isValid("(]");
        System.out.println("false == " + result);
        result = solution.isValid("([)]");
        System.out.println("false == " + result);
        result = solution.isValid("{[]}");
        System.out.println("true == " + result);
    }
}
