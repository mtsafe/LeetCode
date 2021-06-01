package dayChall202106;

class SolutionDay601 {
    int islandArea(int[][] grid, int a, int b) {
        if (grid == null || grid[a][b] != 1 || a < 0 || a >= grid.length ||
                b < 0 || b >= grid[0].length)
            return 0;
        grid[a][b] = 2;
        int result = 1;
        if (a > 0) result += islandArea(grid, a - 1, b);
        if (b > 0) result += islandArea(grid, a, b - 1);
        if (a < grid.length - 1) result += islandArea(grid, a + 1, b);
        if (b < grid[0].length - 1) result += islandArea(grid, a, b + 1);
        return result;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, islandArea(grid, i, j));
            }
        return result;
    }
}

public class Day601_2021 {
    public static void main(String[] args) {
        SolutionDay601 solution = new SolutionDay601();
        int[][] inputG;
        int result;

        // Example 1
        inputG = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        result = solution.maxAreaOfIsland(inputG);
        System.out.println("6 == " + result);

        // Example 2
        inputG = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        result = solution.maxAreaOfIsland(inputG);
        System.out.println("0 == " + result);
    }
}
