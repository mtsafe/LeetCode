package dayChall202102;

import java.util.Arrays;

class SolutionDay117 {
    private int calcArea(int[] height, int leftSide, int rightSide) {
        if (height == null)
            return 0;
        return (rightSide - leftSide) * Math.min(height[rightSide], height[leftSide]);
    }

    public int maxArea(int[] height) {
        if (height == null)
            return 0;
        int leftSide = 0, rightSide = height.length - 1;
        int start = leftSide, end = rightSide;
        while (start < end) {
            if (height[start] == height[end]) {
                start++;
                end--;
                if (start >= end)
                    break;
                if (calcArea(height, start, rightSide) >
                        calcArea(height, leftSide, rightSide)) {
                    leftSide = start;
                }
                if (calcArea(height, leftSide, end) >
                        calcArea(height, leftSide, rightSide)) {
                    rightSide = end;
                }
                if (calcArea(height, start, end) >
                        calcArea(height, leftSide, rightSide)) {
                    leftSide = start;
                    rightSide = end;
                }
            } else if (height[start] > height[end]) {
                end--;
                if (start >= end)
                    break;
                if (calcArea(height, leftSide, end) >
                        calcArea(height, leftSide, rightSide)) {
                    rightSide = end;
                }
                if (calcArea(height, start, end) >
                        calcArea(height, leftSide, rightSide)) {
                    leftSide = start;
                    rightSide = end;
                }
            } else {
                start++;
                if (start >= end)
                    break;
                if (calcArea(height, start, rightSide) >
                        calcArea(height, leftSide, rightSide)) {
                    leftSide = start;
                }
                if (calcArea(height, start, end) >
                        calcArea(height, leftSide, rightSide)) {
                    leftSide = start;
                    rightSide = end;
                }
            }
        }
        return calcArea(height, leftSide, rightSide);
    }
}

public class Day117_2021 {
    public static void main(String[] args) {
        SolutionDay117 solution = new SolutionDay117();
        int[] input;
        int result;

        // Trivial 1
        input = new int[]{1, 1};
        result = solution.maxArea(input);
        System.out.print("Trivial 1: " + Arrays.toString(input) + " :: ");
        System.out.println("1 == " + result);

        // Trivial 2
        input = new int[]{1, 10, 10};
        result = solution.maxArea(input);
        System.out.print("Trivial 2: " + Arrays.toString(input) + " :: ");
        System.out.println("10 == " + result);

        // Trivial 3
        input = new int[]{10, 10, 1};
        result = solution.maxArea(input);
        System.out.print("Trivial 3: " + Arrays.toString(input) + " :: ");
        System.out.println("10 == " + result);

        // Trivial 4
        input = new int[]{1, 10, 10, 1};
        result = solution.maxArea(input);
        System.out.print("Trivial 4: " + Arrays.toString(input) + " :: ");
        System.out.println("10 == " + result);

        // Example 1
        input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        result = solution.maxArea(input);
        System.out.print("Example 1: " + Arrays.toString(input) + " :: ");
        System.out.println("49 == " + result);

        // Example 2
        input = new int[]{1, 1};
        result = solution.maxArea(input);
        System.out.print("Example 2: " + Arrays.toString(input) + " :: ");
        System.out.println("1 == " + result);

        // Example 3
        input = new int[]{4, 3, 2, 1, 4};
        result = solution.maxArea(input);
        System.out.print("Example 3: " + Arrays.toString(input) + " :: ");
        System.out.println("16 == " + result);

        // Example 4
        input = new int[]{1, 2, 1};
        result = solution.maxArea(input);
        System.out.print("Example 4: " + Arrays.toString(input) + " :: ");
        System.out.println("2 == " + result);

        // Testcase 1
        input = new int[]{1, 2, 4, 3};
        result = solution.maxArea(input);
        System.out.print("Testcase 1: " + Arrays.toString(input) + " :: ");
        System.out.println("4 == " + result);

        // Testcase 2
        input = new int[]{2,3,4,5,18,17,6};
        result = solution.maxArea(input);
        System.out.print("Testcase 2: " + Arrays.toString(input) + " :: ");
        System.out.println("17 == " + result);
    }
}
