package dayChall202102;

class SolutionDay127 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (dividend == -2147483648 && divisor == -1) return 2147483647;
        return dividend / divisor;
    }
}

public class Day127_2021 {
    public static void main(String[] args) {
        SolutionDay127 solution = new SolutionDay127();
        int inputDividend, inputDivisor;
        int result;

        // Example 1
        inputDividend = 10;
        inputDivisor = 3;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("3 == " + result);

        // Example 2
        inputDividend = 7;
        inputDivisor = -3;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("-2 == " + result);

        // Example 3
        inputDividend = 0;
        inputDivisor = 1;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("0 == " + result);

        // Example 4
        inputDividend = 1;
        inputDivisor = 1;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("1 == " + result);

        // Testcase 1
        inputDividend = -2147483648;
        inputDivisor = -1;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("2147483647 == " + result);

        // Edge Case 1
        inputDividend = -2147483648;
        inputDivisor = 1;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("-2147483648 == " + result);

        // Edge Case 2
        inputDividend = 2147483647;
        inputDivisor = 1;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("2147483647 == " + result);

        // Edge Case 3
        inputDividend = 1;
        inputDivisor = -2147483648;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("0 == " + result);

        // Edge Case 4
        inputDividend = 1;
        inputDivisor = 2147483647;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("0 == " + result);

        // Edge Case 5
        inputDividend = -2147483648;
        inputDivisor = -2147483648;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("1 == " + result);

        // Edge Case 6
        inputDividend = 2147483647;
        inputDivisor = 2147483647;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("1 == " + result);

        // Test 1
        inputDividend = -2147483648;
        inputDivisor = -2;
        result = solution.divide(inputDividend, inputDivisor);
        System.out.println("1073741824 == " + result);
    }
}
