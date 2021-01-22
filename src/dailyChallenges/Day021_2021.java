package dailyChallenges;

import java.util.Arrays;

class SolutionDay021 {
    public void pushIn(int[] arr, int val) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                while (i < arr.length) {
                    arr[i-1] = arr[i];
                    i++;
                }
                arr[i-1] = val;
            }
        }
        if (arr[arr.length - 1] > val)
            arr[arr.length - 1] = val;
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int[] result = Arrays.copyOfRange(nums, 0, k);
        for (int i = k; i < nums.length; i++) {
            pushIn(result, nums[i]);
        }
        return result;
    }
}

public class Day021_2021 {
    public static void main(String[] args) {
        SolutionDay021 solution = new SolutionDay021();
        int[] result;
        result = solution.mostCompetitive(new int[]{3, 5, 2, 6}, 2);
        System.out.println("[2,6]=="+Arrays.toString(result));
        result = solution.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
        System.out.println("[2,3,3,4]=="+Arrays.toString(result));
        result = solution.mostCompetitive(new int[]{1}, 1);
        System.out.println("[1]=="+Arrays.toString(result));
    }
}
