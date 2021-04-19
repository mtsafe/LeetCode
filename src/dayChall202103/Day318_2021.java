package dayChall202103;

class SolutionDay318 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3)
            if (nums.length == 2 && nums[0] == nums[1])
                return 1;
            else
                return nums.length;
        boolean prev = nums[1] > nums[0], curr;
        int start;
        int inflectionCnt = 1;
        for (start = 1; start < nums.length; start++) {
            if (nums[start] != nums[start - 1]) {
                inflectionCnt++;
                prev = nums[start] > nums[start-1];
                break;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            curr = nums[i] > nums[i - 1];
            if (curr != prev) inflectionCnt++;
            prev = curr;
        }
        return inflectionCnt;
    }
}

public class Day318_2021 {
    public static void main(String[] args) {
        SolutionDay318 solution = new SolutionDay318();
        int[] input;
        int result;

        // Example 1
        input = new int[]{1, 7, 4, 9, 2, 5};
        result = solution.wiggleMaxLength(input);
        System.out.println("6 == " + result);

        // Example 2
        input = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        result = solution.wiggleMaxLength(input);
        System.out.println("7 == " + result);

        // Example 3
        input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        result = solution.wiggleMaxLength(input);
        System.out.println("2 == " + result);

        // Example 4
        input = new int[]{0, 2};
        result = solution.wiggleMaxLength(input);
        System.out.println("2 == " + result);

        // Example 5
        input = new int[]{0, 0};
        result = solution.wiggleMaxLength(input);
        System.out.println("1 == " + result);

        // Example 5
        input = new int[]{0, 0, 0};
        result = solution.wiggleMaxLength(input);
        System.out.println("1 == " + result);

        // Example 5
        input = new int[]{0, 0, 0, 0};
        result = solution.wiggleMaxLength(input);
        System.out.println("1 == " + result);
    }
}
