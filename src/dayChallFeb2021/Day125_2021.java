package dayChallFeb2021;

class SolutionDay125 {
    private int locateLarge(int[] nums, int largeOut) {
        if (nums == null)
            return 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < largeOut)
                return i;
        }
        return 0;
    }

    private int locateSmall(int[] nums, int smallOut) {
        if (nums == null)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > smallOut)
                return i;
        }
        return 0;
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int largeOut = -1000000;
        int smallOut = 1000000;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (largeOut < nums[i - 1]) {
                    largeOut = nums[i - 1];
                }
                if (smallOut > nums[i]) {
                    smallOut = nums[i];
                }
            }
        }
        if (smallOut == 1000000)
            return 0;
        return locateLarge(nums, largeOut) - locateSmall(nums, smallOut) + 1;
    }
}

public class Day125_2021 {
    public static void main(String[] args) {
        SolutionDay125 solution = new SolutionDay125();
        int[] input;
        int result;

        // Example 1
        input = new int[]{2, 6, 4, 8, 10, 9, 15};
        result = solution.findUnsortedSubarray(input);
        System.out.println("5 == " + result);

        // Example 2
        input = new int[]{1, 2, 3, 4};
        result = solution.findUnsortedSubarray(input);
        System.out.println("0 == " + result);

        // Example 3
        input = new int[]{1};
        result = solution.findUnsortedSubarray(input);
        System.out.println("0 == " + result);

        // Test 1
        input = new int[]{4, 2, 6, 8, 9, 10, 15};
        result = solution.findUnsortedSubarray(input);
        System.out.println("2 == " + result);

        // Test 2
        input = new int[]{2, 4, 6, 8, 9, 15, 10};
        result = solution.findUnsortedSubarray(input);
        System.out.println("2 == " + result);

        // Test 3
        input = new int[]{4, 2, 6, 8, 9, 15, 10};
        result = solution.findUnsortedSubarray(input);
        System.out.println("7 == " + result);

        // Test 3
        input = new int[]{4, 2, 6, 8, 15, 9, 10};
        result = solution.findUnsortedSubarray(input);
        System.out.println("7 == " + result);
    }
}
