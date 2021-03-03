package dayChallMar2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionDay302 {
    public int[] findErrorNums(int[] nums) {
        if (nums == null) return null;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        int prev = list.get(0);
        int theDouble = 0, theMissing = 0;
        if (prev != 1)
            theMissing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prev == list.get(i))
                theDouble = prev;
            if (prev + 2 == list.get(i))
                theMissing = prev + 1;
            prev = list.get(i);
        }
        if (theMissing == 0)
            theMissing = nums.length;
        return new int[]{theDouble, theMissing};
    }
}

public class Day302_2021 {
    public static void main(String[] args) {
        SolutionDay302 solution = new SolutionDay302();
        int[] input;
        int[] result;

        // Example 1
        input = new int[]{1, 2, 2, 4};
        result = solution.findErrorNums(input);
        System.out.println("[2,3] == " + Arrays.toString(result));

        // Example 2
        input = new int[]{1, 1};
        result = solution.findErrorNums(input);
        System.out.println("[1,2] == " + Arrays.toString(result));

        // Testcase 1
        input = new int[]{2, 2};
        result = solution.findErrorNums(input);
        System.out.println("[2,1] == " + Arrays.toString(result));

        // Testcase 2
        input = new int[]{3,2,3,4,6,5};
        result = solution.findErrorNums(input);
        System.out.println("[3,1] == " + Arrays.toString(result));
    }
}
