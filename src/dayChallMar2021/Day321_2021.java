package dayChallMar2021;

class SolutionDay321 {
    public boolean reorderedPowerOf2(int N) {
        return false;
    }
}

public class Day321_2021 {
    public static void main(String[] args) {
        SolutionDay321 solution = new SolutionDay321();
        int input;
        boolean result;

        // Example 1
        input = 1;
        result = solution.reorderedPowerOf2(input);
        System.out.println("true == "+result);

        // Example 2
        input = 10;
        result = solution.reorderedPowerOf2(input);
        System.out.println("false == "+result);

        // Example 3
        input = 16;
        result = solution.reorderedPowerOf2(input);
        System.out.println("true == "+result);

        // Example 4
        input = 24;
        result = solution.reorderedPowerOf2(input);
        System.out.println("false == "+result);

        // Example 5
        input = 46;
        result = solution.reorderedPowerOf2(input);
        System.out.println("true == "+result);
    }
}
