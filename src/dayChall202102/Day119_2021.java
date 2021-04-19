package dayChall202102;

import java.util.ArrayList;
import java.util.List;

class SolutionDay119 {
    static class Peeker {
        private final List<Integer> list;
        int next;
        boolean isNextGood;

        Peeker(List<Integer> list) {
            this.list = list;
            isNextGood = false;
        }

        private boolean hasNext() {
            if (isNextGood) return true;
            try {
                next = list.remove(0);
                isNextGood = true;
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        public int peek() {
            if (hasNext())
                return next;
            return -1;
        }

        public void pluck() {
            if (hasNext())
                isNextGood = false;
        }
    }

    public String minRemoveToMakeValid(String s) {
        if (s == null)
            return null;
        List<Integer> openP = new ArrayList<>();
        List<Integer> closeP = new ArrayList<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '(') {
                openP.add(i);
            } else if (ch[i] == ')') {
                if (openP.size() == 0)
                    closeP.add(i);
                else
                    openP.remove(0);
            }
        }
        Peeker pOpenP = new Peeker(openP);
        Peeker pCloseP = new Peeker(closeP);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '(') {
                if (pOpenP.peek() == i) {
                    pOpenP.pluck();
                    continue;
                }
            } else if (ch[i] == ')') {
                if (pCloseP.peek() == i) {
                    pCloseP.pluck();
                    continue;
                }
            }
            str.append(ch[i]);
        }
        return str.toString();
    }
}

public class Day119_2021 {
    public static void main(String[] args) {
        SolutionDay119 solution = new SolutionDay119();
        String input;
        String result;

        // Trivial 1
        input = "";
        result = solution.minRemoveToMakeValid(input);
        System.out.println(" == " + result);

        // Example 1
        input = "lee(t(c)o)de)";
        result = solution.minRemoveToMakeValid(input);
        System.out.println("lee(t(c)o)de == " + result);

        // Example 2
        input = "a)b(c)d";
        result = solution.minRemoveToMakeValid(input);
        System.out.println("ab(c)d == " + result);

        // Example 3
        input = "))((";
        result = solution.minRemoveToMakeValid(input);
        System.out.println(" == " + result);

        // Example 4
        input = "(a(b(c)d)";
        result = solution.minRemoveToMakeValid(input);
        System.out.println("(a(bc)d) == " + result);
    }
}
