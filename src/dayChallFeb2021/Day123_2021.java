package dayChallFeb2021;

class SolutionDay123 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return true;
    }
}

public class Day123_2021 {
    public static void main(String[] args) {
        SolutionDay123 solution = new SolutionDay123();
        int[][] inputM;
        int inputT;
        boolean result;

        // Trivial 1
        inputM = new int[][]{{1}};
        inputT = 1;
        result = solution.searchMatrix(inputM, inputT);
        System.out.println("true == " + result);

        // Example 1
        inputM = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        inputT = 5;
        result = solution.searchMatrix(inputM, inputT);
        System.out.println("true == " + result);

        // Example 2
        inputM = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        inputT = 20;
        result = solution.searchMatrix(inputM, inputT);
        System.out.println("false == " + result);
    }
}
