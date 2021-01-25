package dailyChallenges;

class SolutionDay025 {
    public boolean kLengthApart(int[] nums, int k) {
        int howFar = k;
        for (int num : nums) {
            if (num == 0) {
                howFar++;
                continue;
            }
            if (howFar < k)
                return false;
            howFar = 0;
        }
        return true;
    }
}

public class Day025_2021 {
    public static void main(String[] args) {
        SolutionDay025 solution = new SolutionDay025();
        boolean result;
        int[] input;

        input = new int[]{0, 0};
        result = solution.kLengthApart(input, 2);
        System.out.println("true == " + result);

        input = new int[]{0, 1, 0};
        result = solution.kLengthApart(input, 3);
        System.out.println("true == " + result);

        input = new int[]{1, 0, 0, 0, 1, 0, 0, 1};
        result = solution.kLengthApart(input, 2);
        System.out.println("true == " + result);

        input = new int[]{1, 0, 0, 1, 0, 1};
        result = solution.kLengthApart(input, 2);
        System.out.println("false == " + result);

        input = new int[]{1, 1, 1, 1, 1};
        result = solution.kLengthApart(input, 0);
        System.out.println("true == " + result);

        input = new int[]{0, 1, 0, 1};
        result = solution.kLengthApart(input, 1);
        System.out.println("true == " + result);
    }
}
