package dayChall202102;

import java.util.Stack;

class SolutionDay126 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pusher = 0;
        int popper = 0;
        while (popper < popped.length) {
            if (stack.empty()) {
                if (pusher < pushed.length)
                    stack.push(pushed[pusher++]);
                else
                    break;
            }
            if (popped[popper] == stack.peek()) {
                stack.pop();
                popper++;
            } else if (pusher < pushed.length)
                stack.push(pushed[pusher++]);
            else
                return false;
        }
        return true;
    }
}

public class Day126_2021 {
    public static void main(String[] args) {
        SolutionDay126 solution = new SolutionDay126();
        int[] inputPush;
        int[] inputPop;
        boolean result;

        // Example 1
        inputPush = new int[]{1, 2, 3, 4, 5};
        inputPop = new int[]{4, 5, 3, 2, 1};
        result = solution.validateStackSequences(inputPush, inputPop);
        System.out.println("true == " + result);

        // Example 2
        inputPush = new int[]{1, 2, 3, 4, 5};
        inputPop = new int[]{4, 3, 5, 1, 2};
        result = solution.validateStackSequences(inputPush, inputPop);
        System.out.println("false == " + result);
    }
}
