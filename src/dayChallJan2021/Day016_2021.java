package dayChallJan2021;

import java.util.Arrays;

class SolutionDay016 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return (nums[nums.length - k]);
    }
}
public class Day016_2021 {
    public static void main(String[] args) {
        SolutionDay016 solution = new SolutionDay016();
        int result;
        result = solution.findKthLargest(new int[]
                {3,2,1,5,6,4}, 2);
        System.out.println(result);
        result = solution.findKthLargest(new int[]
                {3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(result);
    }
}
