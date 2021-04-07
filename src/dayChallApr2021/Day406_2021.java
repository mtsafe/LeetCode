package dayChallApr2021;

class SolutionDay406 {
    public int minOperations(int n) {
        int minOps = 0;
        for (int i = 1 + (n%2); i < n; i++, i++) {
            minOps += i;
        }
        return minOps;
    }
}

public class Day406_2021 {
    public static void main(String[] args) {
        SolutionDay406 solution = new SolutionDay406();
        int inputN;
        int result;

        // Example 1
        inputN = 3;
        result = solution.minOperations(inputN);
        System.out.println("2 == "+result);

        // Example 2
        inputN = 6;
        result = solution.minOperations(inputN);
        System.out.println("9 == "+result);
    }
}
