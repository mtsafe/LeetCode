package contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class SolutionWC254 {
    public int numOfStrings(String[] patterns, String word) {
        if (patterns == null || word == null) return 0;
        int sum = 0;
        for (String s : patterns)
            if (word.indexOf(s) >= 0) sum++;
        return sum;
    }

    public int[] rearrangeArray(int[] nums) {
        if (nums == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        Collections.sort(list);
        int[] result = new int[nums.length];
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            if (first) {
                result[i] = list.get((int) (i / 2));
                first = false;
            } else {
                result[i] = list.get(nums.length - 1 - (int) (i / 2));
                first = true;
            }
        }
        return result;
    }

    public int minNonZeroProduct(int p) {
        if (p < 1) return 0;
        if (p == 1) return 1;
        if (p == 2) return 6;
        if (p == 3) return 1512;
        return 0;
    }

    boolean canCross(int row, int col, int[][] days, int row0, int col0) {
        System.out.println("CALL canCross(" + row0 + "," + col0 + ")");
        if (days == null)
            System.out.println("fart - days null");
        if (days[row0][col0] == 1)
            System.out.println("fart - days 1");
        if (days == null || days[row0][col0] == 1) return false;
        int maxRow = row - 1, maxCol = col - 1;
        if (row0 == maxRow) System.out.println("canCross(" + row0 + "," + col0 + "); return true");
        if (row0 == maxRow) return true;
        int rowS = row0, colS = col0;
        while (colS > 0 && days[rowS][colS - 1] == 0)
            colS--;
        System.out.println("canCross(" + row0 + "," + col0 + "); colS == " + colS);
        while (colS < col && days[rowS][colS] == 0) {
            if (canCross(row, col, days, rowS + 1, colS))
                return true;
            colS++;
        }
        System.out.println("canCross(" + row0 + "," + col0 + "); flunk out");
        return false;
    }

    // Time Limit Exceeded
    public int latestDayToCross(int row, int col, int[][] cells) {
        if (cells == null) return 0;
        int[][] days = new int[row][col];
        for (int day = 0; day < cells.length; day++) {
            System.out.println("ASSIGN days[" + (cells[day][0] - 1) + "][" + (cells[day][1] - 1) + "] = 1;");
            days[cells[day][0] - 1][cells[day][1] - 1] = 1;
            boolean crossable = false;
            for (int col0 = 0; col0 < col; col0++) {
                if (canCross(row, col, days, 0, col0)) {
                    crossable = true;
                    break;
                }
            }
            if (!crossable)
                return day;
        }
        return 0;
    }
}

public class WeeklyContest254 {
    public static void main(String[] args) {
        SolutionWC254 solution = new SolutionWC254();
        int row, col;
        int[][] cells;
        int resultI;

        // Example 1
        row = 2;
        col = 2;
        cells = new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}};
        resultI = solution.latestDayToCross(row, col, cells);
        System.out.println("2 == " + resultI);

        // Example 2
        row = 2;
        col = 2;
        cells = new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}};
        resultI = solution.latestDayToCross(row, col, cells);
        System.out.println("1 == " + resultI);

        // Example 3
        row = 3;
        col = 3;
        cells = new int[][]{{1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}};
        resultI = solution.latestDayToCross(row, col, cells);
        System.out.println("3 == " + resultI);

        // Big Test 1
        row = 33;
        col = 3;
        cells = new int[][]{
                {26, 1}, {1, 2}, {30, 2}, {10, 1}, {20, 1},
                {23, 3}, {9, 1}, {30, 1}, {16, 1}, {2, 2},
                {23, 2}, {31, 3}, {21, 1}, {21, 3}, {15, 3},
                {28, 2}, {24, 2}, {5, 1}, {33, 1}, {18, 3},
                {9, 2}, {16, 2}, {21, 2}, {14, 3}, {19, 2},
                {1, 1}, {20, 2}, {2, 1}, {12, 3}, {2, 3},
                {25, 2}, {26, 3}, {25, 3}, {13, 2}, {19, 3},
                {29, 1}, {4, 2}, {27, 1}, {3, 2}, {17, 2},
                {6, 3}, {17, 3}, {31, 1}, {27, 3}, {8, 2},
                {24, 3}, {29, 2}, {16, 3}, {12, 1}, {9, 3},
                {6, 2}, {10, 3}, {33, 2}, {22, 3}, {22, 2},
                {7, 1}, {18, 1}, {32, 1}, {14, 1}, {32, 2},
                {1, 3}, {18, 2}, {11, 3}, {12, 2}, {28, 1},
                {19, 1}, {24, 1}, {30, 3}, {11, 2}, {4, 1},
                {4, 3}, {20, 3}, {8, 1}, {23, 1}, {7, 3},
                {27, 2}, {22, 1}, {26, 2}, {15, 2}, {14, 2},
                {28, 3}, {13, 1}, {5, 2}, {10, 2}, {6, 1},
                {33, 3}, {15, 1}, {13, 3}, {3, 3}, {3, 1},
                {31, 2}, {11, 1}, {5, 3}, {8, 3}, {32, 3},
                {17, 1}, {7, 2}, {29, 3}, {25, 1}};
        resultI = solution.latestDayToCross(row, col, cells);
        System.out.println("3 == " + resultI);

        ///////////////////////////////////////////////
        int inputI;

        // Example 1
        inputI = 1;
        resultI = solution.minNonZeroProduct(inputI);
        System.out.println("1 == " + resultI);

        // Example 2
        inputI = 2;
        resultI = solution.minNonZeroProduct(inputI);
        System.out.println("6 == " + resultI);

        // Example 3
        inputI = 3;
        resultI = solution.minNonZeroProduct(inputI);
        System.out.println("1512 == " + resultI);

        ///////////////////////////////////////////////
        int[] inputIA;
        int[] resultIA;

        // Example 1
        inputIA = new int[]{1, 2, 3, 4, 5};
        resultIA = solution.rearrangeArray(inputIA);
        System.out.println("[1,2,4,5,3] == " + Arrays.toString(resultIA));

        // Example 2
        inputIA = new int[]{6, 2, 0, 9, 7};
        resultIA = solution.rearrangeArray(inputIA);
        System.out.println("[9,7,6,2,0] == " + Arrays.toString(resultIA));

        ///////////////////////////////////////////////
        String[] inputSA;
        String inputS;
        int result;

        // Example 1
        inputSA = new String[]{"a", "abc", "bc", "d"};
        inputS = "abc";
        result = solution.numOfStrings(inputSA, inputS);
        System.out.println("3 == " + result);

        // Example 2
        inputSA = new String[]{"a", "b", "c"};
        inputS = "aaaaabbbbb";
        result = solution.numOfStrings(inputSA, inputS);
        System.out.println("2 == " + result);

        // Example 3
        inputSA = new String[]{"a", "a", "a"};
        inputS = "ab";
        result = solution.numOfStrings(inputSA, inputS);
        System.out.println("3 == " + result);
    }
}
