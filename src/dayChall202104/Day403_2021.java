package dayChall202104;

import java.util.Stack;

class SolutionDay403 {
    static class CntNStr {
        int cnt;
        String str;

        CntNStr(int cnt, String str) {
            this.cnt = cnt;
            this.str = str;
        }
    }

    CntNStr extractPairs(String str) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 1; i < str.length(); i++) {
            if (chars[i - 1] == '(' && chars[i] == ')') {
                i++;
                cnt++;
                cnt++;
                if (i == str.length() - 1)
                    sb.append(chars[i]);
                continue;
            }
            sb.append(chars[i - 1]);
        }
        return new CntNStr(cnt, sb.toString());
    }

    public int longestValidParentheses_1stTry(String s) {
        int total = 0;
        CntNStr cns = new CntNStr(1, s);
        while (cns.cnt != 0) {
            cns = extractPairs(cns.str);
            total += cns.cnt;
            s = cns.str;
        }
        return total;
    }

    public static class ValidLengthObj {
        int maxLength;
        int endsAt;

        ValidLengthObj() {
            this.maxLength = 0;
            this.endsAt = 0;
        }

        void print() {
            System.out.println("maxLength == " + this.maxLength + "; endsAt == " + this.endsAt);
        }
    }

    String truncateLVP(String s) {
        System.out.println("truncateLVP");
        if (s == null || s.length() < 2) return "";
        char[] chars = s.toCharArray();
        int start = s.length(), stop = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                start = i;
                break;
            }
        }
        for (int i = s.length() - 1; i > start; i--) {
            if (chars[i] == ')') {
                stop = i + 1;
                break;
            }
        }
        return s.substring(start, stop);
    }

    ValidLengthObj validLength(String s) {
        if (depthCharge++ > 10) return null;
        System.out.println("validLength(\"" + s + "\")");
        ValidLengthObj result = new ValidLengthObj();
        if (s == null || s.length() < 2) return result;
        char[] chars = s.toCharArray();
        if (chars[0] == ')') return result;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> maxLenStk = new Stack<>();
        int segmentLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (stack.empty()) {
                result.maxLength += segmentLength;
                segmentLength = 0;
            }
            if (chars[i] == '(') {
                stack.push('(');
                continue;
            }
            if (stack.empty()) {
                result.maxLength = Math.max(result.maxLength, segmentLength);
                result.print();
                return result;
            }
            stack.pop();
            result.endsAt = i + 1;
            segmentLength += 2;
        }
        if (stack.empty())
            result.maxLength += segmentLength;
        else
            result.maxLength = Math.max(result.maxLength, segmentLength);
        result.print();
        return result;
    }

    /*
        int validLength(String s) {
            if (s == null || s.length() < 2) return 0;
            char[] chars = s.toCharArray();
            int maxLength = 0;
            if (chars[1] == ')') {
                maxLength += 2;
                if (chars.length > 2) {
                    if (chars[2] == '(') {
                        maxLength += validLength(s.substring(2, chars.length - 2));
                    }
                }
                return maxLength;
            }


        }
    */
    int depthCharge = 0;

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        System.out.println("longestValidParentheses");
        s = truncateLVP(s);
        char[] chars = s.toCharArray();
        int maxLength = 0;
        ValidLengthObj vlo;
        for (int i = 0; i < chars.length; i++) {
            System.out.println("longestValidParentheses: i == " + i);
            if (chars[i] == '(') {
                vlo = validLength(s.substring(i));
                i += vlo.endsAt - 1;
                vlo.print();
                maxLength = Math.max(maxLength, vlo.maxLength);
                vlo.print();
            }
        }
        return maxLength;
    }
}

public class Day403_2021 {
    public static void main(String[] args) {
        SolutionDay403 solution = new SolutionDay403();
        String inputS;
        int result;

        // Example 1
        inputS = "(()";
        result = solution.longestValidParentheses(inputS);
        System.out.println("2 == " + result);

        // Example 2
        inputS = ")()())";
        result = solution.longestValidParentheses(inputS);
        System.out.println("4 == " + result);

        // Example 3
        inputS = "";
        result = solution.longestValidParentheses(inputS);
        System.out.println("0 == " + result);

        // Test Case 1
        inputS = "()(())";
        result = solution.longestValidParentheses(inputS);
        System.out.println("6 == " + result);

        // Test Case 2
        inputS = "()(()";
        result = solution.longestValidParentheses(inputS);
        System.out.println("2 == " + result);
    }
}
