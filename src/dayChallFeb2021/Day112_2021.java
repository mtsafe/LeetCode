package dayChallFeb2021;

class SolutionDay112 {
    public int numberOfSteps(int num) {
        int stepCnt = 0;
        while (num != 0) {
            while (num % 2 == 0) {
                num /= 2;
                stepCnt++;
            }
            num--;
            stepCnt++;
        }
        return stepCnt;
    }
}

public class Day112_2021 {
    public static void main(String[] args) {
        SolutionDay112 solution = new SolutionDay112();
        int input;
        int result;

        // Example 1
        input = 14;
        result = solution.numberOfSteps(input);
        System.out.println("6 == " + result);

        // Example 2
        input = 8;
        result = solution.numberOfSteps(input);
        System.out.println("4 == " + result);

        // Example 3
        input = 123;
        result = solution.numberOfSteps(input);
        System.out.println("12 == " + result);
    }
}
