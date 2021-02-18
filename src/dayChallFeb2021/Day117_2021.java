package dayChallFeb2021;

class SolutionDay117 {
    public int maxArea(int[] height) {
        if (height == null)
            return 0;
        int leftSide = 0, rightSide = height.length - 1;
        int start = leftSide, end = rightSide;
        while (start < end) {
            if (height[leftSide] > height[rightSide]) {
                while (height[end] < height[rightSide] &&
                        start < end) {
                    end--;
                }
                if (start >= end)
                    break;
                if ((end - leftSide) * Math.min(height[end], height[leftSide]) >
                        (rightSide - leftSide) * Math.min(height[rightSide], height[leftSide])) {
                    rightSide = end;
                }
            } else {
                while (height[start] >= height[leftSide] &&
                        start < end) {
                    start++;
                }
                if (start >= end)
                    break;
                if ((rightSide - start) * Math.min(height[start], height[rightSide]) >
                        (rightSide - leftSide) * Math.min(height[rightSide], height[leftSide])) {
                    leftSide = start;
                }
            }
        }
        System.out.println("R=" + rightSide + " : " + "L=" + leftSide);
        return (rightSide - leftSide) * Math.min(height[rightSide], height[leftSide]);
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
        System.out.println("1 == " + result);

        // Trivial 2
        input = new int[]{1, 10, 10};
        result = solution.maxArea(input);
        System.out.println("100 == " + result);

        // Trivial 3
        input = new int[]{10, 10, 1};
        result = solution.maxArea(input);
        System.out.println("100 == " + result);

        // Trivial 4
        input = new int[]{1, 10, 10, 1};
        result = solution.maxArea(input);
        System.out.println("100 == " + result);

        // Example 1
        input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        result = solution.maxArea(input);
        System.out.println("49 == " + result);

        // Example 2
        input = new int[]{1, 1};
        result = solution.maxArea(input);
        System.out.println("1 == " + result);

        // Example 3
        input = new int[]{4, 3, 2, 1, 4};
        result = solution.maxArea(input);
        System.out.println("16 == " + result);

        // Example 4
        input = new int[]{1, 2, 1};
        result = solution.maxArea(input);
        System.out.println("2 == " + result);
    }
}
