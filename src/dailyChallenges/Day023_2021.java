package dailyChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class SolutionDay023 {
    int[][] mat;

    private void sortOneDiagonal(int iStart, int jStart, int maxOffset) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int offset = 0; offset <= maxOffset; offset++)
            list.add(mat[iStart + offset][jStart + offset]);
        Collections.sort(list);
        for (int offset = 0; offset <= maxOffset; offset++)
            mat[iStart + offset][jStart + offset] = list.remove(0);
    }

    public int[][] diagonalSort(int[][] mat) {
        this.mat = mat;
        int iMax = mat.length - 1;
        int jMax = mat[0].length - 1;
        int maxOffset = Math.min(iMax, jMax);
        for (int i = 1; i < iMax; i++) {
            sortOneDiagonal(i, 0, Math.min(iMax - i, maxOffset));
        }
        for (int j = 0; j < jMax; j++) {
            sortOneDiagonal(0, j, Math.min(jMax - j, maxOffset));
        }
        return mat;
    }
}

public class Day023_2021 {
    public static void printArray(int[][] arr) {
        System.out.println("[");
        for (int[] output : arr) {
            System.out.println(Arrays.toString(output));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SolutionDay023 solution = new SolutionDay023();
        int[][] input, result;

        input = new int[][]{
                new int[]{3, 3, 1, 1},
                new int[]{2, 2, 1, 2},
                new int[]{1, 1, 1, 2}
        };
        printArray(input);
        result = solution.diagonalSort(input);
        printArray(result);

        input = new int[][]{
                new int[]{3, 3, 1, 1},
                new int[]{2, 2, 1, 2},
                new int[]{2, 5, 1, 2},
                new int[]{2, 2, 9, 2},
                new int[]{7, 2, 1, 2},
                new int[]{2, 9, 8, 2},
                new int[]{6, 1, 1, 2}
        };
        printArray(input);
        result = solution.diagonalSort(input);
        printArray(result);
    }
}
