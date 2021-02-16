package dayChallFeb2021;

import java.util.Arrays;

class SolutionDay115 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] rows = new int[k];
        return rows;
    }
}

public class Day115_2021 {
    public static void main(String[] args) {
        SolutionDay115 solution = new SolutionDay115();
        int[][] input;
        int[] result;

        // Trivial 1
        input = new int[][]{{1,0},{1,1}};
        result = solution.kWeakestRows(input, 0);
        System.out.println("[] == " + Arrays.toString(result));

        // Trivial 2
        input = new int[][]{{1,0},{1,1}};
        result = solution.kWeakestRows(input, 1);
        System.out.println("[0] == " + Arrays.toString(result));

        // Trivial 3
        input = new int[][]{{1,0},{1,1}};
        result = solution.kWeakestRows(input, 2);
        System.out.println("[0,1] == " + Arrays.toString(result));

        // Example 1
        input = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        result = solution.kWeakestRows(input, 3);
        System.out.println("[2,0,3] == " + Arrays.toString(result));

        // Example 2
        input = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        result = solution.kWeakestRows(input, 2);
        System.out.println("[0,2] == " + Arrays.toString(result));
    }
}
