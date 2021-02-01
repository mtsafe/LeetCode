package dayChallJan2021;

import java.util.Arrays;

class SolutionDay031 {
    private void sortToEnd(int[] nums, int start) {
//        System.out.println("sortToEnd("+Arrays.toString(nums)+", "+start+")");
        int tmpInt;
        int stop = nums.length;
        while (start < stop) {
            int newStop = stop - 1;
            for (int i = start; i < stop - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    tmpInt = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmpInt;
                    newStop = i + 1;
                }
            }
            stop = newStop;
        }
    }

    private void incrementArray(int[] nums, int flipPoint) {
//        System.out.println("incrementArray("+Arrays.toString(nums)+", "+flipPoint+")");
        int flipper = flipPoint;
        int flipperVal = 101;
        for (int i = flipPoint + 1; i < nums.length; i++) {
            if (nums[i] > nums[flipPoint] &&
                    nums[i] < flipperVal) {
                flipper = i;
                flipperVal = nums[i];
            }
        }
        int tmp = nums[flipPoint];
        nums[flipPoint] = nums[flipper];
        nums[flipper] = tmp;
        sortToEnd(nums, flipPoint + 1);
    }

    private int findFlipPoint(int[] nums) {
//        System.out.println("findFlipPoint("+Arrays.toString(nums)+")");
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }

    private void reverseIt(int[] nums) {
//        System.out.println("reverseIt("+Arrays.toString(nums)+")");
        int tmp;
        for (int i = 0; i < nums.length / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }

    public void nextPermutation(int[] nums) {
//        System.out.println("nextPermutation("+Arrays.toString(nums)+")");
        if (nums.length < 2) {
            return;
        }

        int thisMustChange = findFlipPoint(nums);
        if (thisMustChange == -1) {
            reverseIt(nums);
            return;
        }

        incrementArray(nums, thisMustChange);
    }
}

public class Day031_2021 {
    public static void main(String[] args) {
        SolutionDay031 solution = new SolutionDay031();
        int[] nums;
        int[] input;

        // Example 1
        nums = new int[]{1, 2, 3};
        input = Arrays.copyOf(nums, nums.length);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(input)+" =>   "+Arrays.toString(nums)+
                " == [1, 3, 2]");

        // Example 2
        nums = new int[]{3, 2, 1};
        input = Arrays.copyOf(nums, nums.length);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(input)+" =>   "+Arrays.toString(nums)+
                " == [1, 2, 3]");

        // Example 3
        nums = new int[]{1, 1, 5};
        input = Arrays.copyOf(nums, nums.length);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(input)+" =>   "+Arrays.toString(nums)+
                " == [1, 5, 1]");

        // Example 4
        nums = new int[]{1};
        input = Arrays.copyOf(nums, nums.length);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(input)+" =>   "+Arrays.toString(nums)+
                " == [1]");

        // Hidden Testcase 1
        nums = new int[]{1, 3, 2};
        input = Arrays.copyOf(nums, nums.length);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(input)+" =>   "+Arrays.toString(nums)+
                " == [2, 1, 3]");

        // Hidden Testcase 1
        nums = new int[]{1, 4, 5, 3, 2};
        input = Arrays.copyOf(nums, nums.length);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(input)+" =>   "+Arrays.toString(nums)+
                " == [1, 5, 2, 3, 4]");
    }
}
