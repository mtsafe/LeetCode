package dailyChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class SolutionDay023 {
    int[][] mat;
    int iMax;
    int jMax;
    int maxOffset;

    private void sortOneDiagonalStartLeft(int iStart) {
        final int jStart = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int jOffset = 0; jOffset <= Math.min(iMax - iStart, maxOffset); jOffset++)
            list.add(mat[iStart + jOffset][jStart + jOffset]);
        Collections.sort(list);
        for (int jOffset = 0; jOffset <= Math.min(iMax - iStart, maxOffset); jOffset++)
            mat[iStart + jOffset][jStart + jOffset] = list.remove(0);
    }

    private void sortOneDiagonalStartTop(int jStart) {
        final int iStart = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int iOffset = 0; iOffset <= Math.min(jMax - jStart, maxOffset); iOffset++)
            list.add(mat[iStart + iOffset][jStart + iOffset]);
        Collections.sort(list);
        for (int iOffset = 0; iOffset <= Math.min(jMax - jStart, maxOffset); iOffset++)
            mat[iStart + iOffset][jStart + iOffset] = list.remove(0);
    }

    public int[][] diagonalSort(int[][] mat) {
        this.mat = mat;
        iMax = mat.length - 1;
        jMax = mat[0].length - 1;
        maxOffset = Math.min(iMax, jMax);
        for (int i = 1; i < iMax; i++) {
            sortOneDiagonalStartLeft(i);
        }
        for (int j = 0; j < jMax; j++) {
            sortOneDiagonalStartTop(j);
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
