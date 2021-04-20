package dayChall202104;

import java.util.Arrays;

class SolutionDay419 {
    int makeCombos(int[] nums, int max, int target) {
        System.out.println("makeCombos(" + Arrays.toString(nums) +
                ", max == " + max + "; target == " + target + ";)");
        if (max < 0 || target < 1) return 0;
        if (nums[max] == target) return 1;
        int comboCnt = 0;
        int top = target / nums[max];
        if (target % nums[max] == 0) {
            System.out.println("comboCnt++");
            comboCnt++;
            top--;
        }
        if (max < 1) return comboCnt;
        for (; top > 0; top--) {
            System.out.println("comboCnt == " + comboCnt);
            comboCnt += makeCombos(nums, max - 1, target - top * nums[max]);
        }
        return comboCnt;
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null) return 0;
        Arrays.sort(nums);
        if (nums[0] > target) return 0;
        int max;
        for (max = 0; max < nums.length && nums[max] < target; max++) {
        }
        if (max >= nums.length) max = nums.length - 1;
        if (nums[max] > target) max--;
        int comboCnt = 0;
        for (int i = max; i >= 0; i--)
            comboCnt += makeCombos(nums, i, target);
        return comboCnt;
    }
}

public class Day419_2021 {
    public static void main(String[] args) {
        SolutionDay419 solution = new SolutionDay419();
        int[] inputN;
        int inputT;
        int result;

        System.out.println("=== Array of 1 ===");
        // Trivial 1
        inputN = new int[]{1};
        inputT = 1;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("1 == " + result);

        // Test 12
        inputN = new int[]{1};
        inputT = 2;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("1 == " + result);

        // Test 13
        inputN = new int[]{1};
        inputT = 3;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("1 == " + result);

        System.out.println("=== Array of 2 ===");
        // Test 21
        inputN = new int[]{1,2};
        inputT = 1;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("1 == " + result);

        // Test 22
        inputN = new int[]{1,2};
        inputT = 2;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("2 == " + result);

        // Test 23
        inputN = new int[]{1,2};
        inputT = 3;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("2 == " + result);

        // Test 24
        inputN = new int[]{1,2};
        inputT = 4;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("3 == " + result);

        // Test 25
        inputN = new int[]{1,2};
        inputT = 5;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("3 == " + result);

        System.out.println("=== Array of 3 ===");
        // Test 31
        inputN = new int[]{1,2,3};
        inputT = 1;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("1 == " + result);

        // Test 32
        inputN = new int[]{1,2,3};
        inputT = 2;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("2 == " + result);

        // Test 33
        inputN = new int[]{1,2,3};
        inputT = 3;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("3 == " + result);

        // Test 34
        inputN = new int[]{1,2,3};
        inputT = 4;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("4 == " + result);

        // Test 35
        inputN = new int[]{1,2,3};
        inputT = 5;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("5 == " + result);

        // Test 36
        inputN = new int[]{1,2,3};
        inputT = 6;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("7 == " + result);

        // Test 37
        inputN = new int[]{1,2,3};
        inputT = 7;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("8 == " + result);

        // Test 38
        inputN = new int[]{1,2,3};
        inputT = 8;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("10 == " + result);

        // Test 39
        inputN = new int[]{1,2,3};
        inputT = 9;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("12 == " + result);

        System.out.println("=== Examples ===");
        // Example 1
        inputN = new int[]{1, 2, 3};
        inputT = 4;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("7 == " + result);

        // Example 2
        inputN = new int[]{9};
        inputT = 3;
        result = solution.combinationSum4(inputN, inputT);
        System.out.println("0 == " + result);
    }
}
