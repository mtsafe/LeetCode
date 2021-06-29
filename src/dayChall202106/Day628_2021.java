package dayChall202106;

import java.util.Stack;

class SolutionDay628 {
    public String removeDuplicates(String s) {
        if (s==null) return null;
        Stack<Character> stack = new Stack<>();
        for (char ch:s.toCharArray()) {
            if (stack.empty() || stack.peek() != ch)
                stack.push(ch);
            else
                stack.pop();
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.insert(0, stack.pop().toString());
        }
        return result.toString();
    }
}

public class Day628_2021 {
    public static void main(String[] args) {
        SolutionDay628 solution = new SolutionDay628();
        String inputS;
        String result;

        // Example 1
        inputS = "abbaca";
        result = solution.removeDuplicates(inputS);
        System.out.println("ca == "+result);

        // Example 2
        inputS = "azxxzy";
        result = solution.removeDuplicates(inputS);
        System.out.println("ay == "+result);
    }
}
