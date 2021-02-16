package dayChallFeb2021;

import java.util.Arrays;

class SolutionDay115 {
    private void insertSorter(int[][] sorter, int sum, int  row) {
        if (sorter == null)
            return;
        boolean inserted = false;
        int sumP = 0, rowP = 0, sumT, rowT;
        for (int i = 0; i < sorter.length; i++) {
            if (!inserted && sorter[i][1] == 0) {
                sorter[i][0] = sum;
                sorter[i][1] = row;
                return;
            }
            if (inserted) {
                sumT = sorter[i][0];
                rowT = sorter[i][1];
                sorter[i][0] = sumP;
                sorter[i][1] = rowP;
                sumP = sumT;
                rowP = rowT;
                continue;
            }
            if (sorter[i][0] > sum) {
                sumP = sorter[i][0];
                rowP = sorter[i][1];
                sorter[i][0] = sum;
                sorter[i][1] = row;
                inserted = true;
            }
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null)
            return null;
        int[][] sorter = new int[mat.length][2];
        int sum;
        for (int row = 0; row < mat.length; row++) {
            sum = 0;
            for (int dude : mat[row]) {
                sum += dude;
            }
            insertSorter(sorter, sum, row + 1);
        }
        int[] rows = new int[k];
        for (int i = 0; i < k; i++) {
            rows[i] = sorter[i][1] - 1;
        }
        return rows;
    }
}

public class Day115_2021 {
    public static void main(String[] args) {
        SolutionDay115 solution = new SolutionDay115();
        int[][] input;
        int[] result;

        // Trivial 1
        input = new int[][]{{1, 0}, {1, 1}};
        result = solution.kWeakestRows(input, 1);
        System.out.println("[0] == " + Arrays.toString(result));

        // Trivial 2
        input = new int[][]{{1, 0}, {1, 1}};
        result = solution.kWeakestRows(input, 2);
        System.out.println("[0,1] == " + Arrays.toString(result));

        // Test 1
        input = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        result = solution.kWeakestRows(input, 5);
        System.out.println("[2,0,3,1,4] == " + Arrays.toString(result));

        // Test 2
        input = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        result = solution.kWeakestRows(input, 4);
        System.out.println("[0,2,3,1] == " + Arrays.toString(result));

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
