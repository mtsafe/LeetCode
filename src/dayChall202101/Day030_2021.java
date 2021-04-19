package dayChall202101;

import java.util.Arrays;

class SolutionDay030 {
    int maxVal;
    int minVal;

    private int deviation() {
        if (maxVal == 1 || minVal == 100001)
            return 0;
        return maxVal - minVal;
    }

    public int minimumDeviation(int[] nums) {
        maxVal = 1;
        minVal = 100001;
        for (int num: nums) {
            if (num % 2 == 0) {
                if (num > maxVal)
                    maxVal = num;
            } else {
                if (num < minVal)
                    minVal = num;
            }
//            System.out.println(num+" "+minVal+" "+maxVal);
        }
        return deviation();
    }
}

public class Day030_2021 {
    public static void main(String[] args) {
        SolutionDay030 solution = new SolutionDay030();
        int[] input;
        int result;

        input = new int[] {10,9};
        result = solution.minimumDeviation(input);
        System.out.println("1 == "+result+" "+Arrays.toString(input));

        input = new int[] {10,10};
        result = solution.minimumDeviation(input);
        System.out.println("0 == "+result+" "+Arrays.toString(input));

        input = new int[] {9,9};
        result = solution.minimumDeviation(input);
        System.out.println("0 == "+result+" "+Arrays.toString(input));

        input = new int[] {1,1};
        result = solution.minimumDeviation(input);
        System.out.println("0 == "+result+" "+Arrays.toString(input));

        // Example 1
        input = new int[] {1,2,3,4};
        result = solution.minimumDeviation(input);
        System.out.println("1 == "+result+" "+Arrays.toString(input));

        // Example 2
        input = new int[] {4,1,5,20,3};
        result = solution.minimumDeviation(input);
        System.out.println("3 == "+result+" "+Arrays.toString(input));

        // Example 3
        input = new int[] {2,10,8};
        result = solution.minimumDeviation(input);
        System.out.println("3 == "+result+" "+Arrays.toString(input));
    }
}
