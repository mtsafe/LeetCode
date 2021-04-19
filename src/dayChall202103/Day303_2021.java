package dayChall202103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SolutionDay303 {
    public int missingNumber(int[] nums) {
        if (nums == null) return 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        Collections.sort(list);
        for (int i = 0; i < nums.length; i++) {
            if (i != list.remove(0)) return i;
        }
        return nums.length;
    }
}

public class Day303_2021 {
    public static void main(String[] args) {
        SolutionDay303 solution = new SolutionDay303();
        int[] input;
        int result;

        // Example 1
        input = new int[]{3, 0, 1};
        result = solution.missingNumber(input);
        System.out.println("2 == " + result);

        // Example 2
        input = new int[]{0, 1};
        result = solution.missingNumber(input);
        System.out.println("2 == " + result);

        // Example 3
        input = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        result = solution.missingNumber(input);
        System.out.println("8 == " + result);

        // Example 4
        input = new int[]{0};
        result = solution.missingNumber(input);
        System.out.println("1 == " + result);
    }
}
