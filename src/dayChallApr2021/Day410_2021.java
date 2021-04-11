package dayChallApr2021;

import java.util.HashSet;

class SolutionDay410 {
    int[][] grid;
    int maxRow, maxCol;
    HashSet<Integer> peaks, valleys;

    void identifyPeaksAndValleys() {
        int position;
        boolean isPeak, isValley;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                position = i * maxCol + j;
                isPeak = true;
                isValley = true;
                if (i > 0) {
                    if (grid[i][j] > grid[i - 1][j])
                        isValley = false;
                    else if (grid[i][j] < grid[i - 1][j])
                        isPeak = false;
                }
                if (j > 0) {
                    if (grid[i][j] > grid[i][j - 1])
                        isValley = false;
                    else if (grid[i][j] < grid[i][j - 1])
                        isPeak = false;
                }
                if (i < maxRow - 1) {
                    if (grid[i][j] > grid[i + 1][j])
                        isValley = false;
                    else if (grid[i][j] < grid[i + 1][j])
                        isPeak = false;
                }
                if (j < maxCol - 1) {
                    if (grid[i][j] > grid[i][j + 1])
                        isValley = false;
                    else if (grid[i][j] < grid[i][j + 1])
                        isPeak = false;
                }
                if (isPeak) peaks.add(position);
                if (isValley) valleys.add(position);
            }
        }
    }

    int longestPath(int position, HashSet<Integer> visited) {
        if (visited == null) return 0;
        visited.add(position);
        int maxPathLen = visited.size();
        if (peaks.contains(position)) return maxPathLen;

        int row, col, newPosition;
        row = position / maxCol;
        col = position % maxCol;

        newPosition = position - 1;
        if (col > 0 &&
                grid[row][col] < grid[row][col - 1] &&
                !visited.contains(newPosition)) {
            maxPathLen = Math.max(maxPathLen,
                    longestPath(newPosition, new HashSet<>(visited)));
        }
        newPosition = position + 1;
        if (col < maxCol - 1 &&
                grid[row][col] < grid[row][col + 1] &&
                !visited.contains(newPosition)) {
            maxPathLen = Math.max(maxPathLen,
                    longestPath(newPosition, new HashSet<>(visited)));
        }
        newPosition = position - maxCol;
        if (row > 0 &&
                grid[row][col] < grid[row - 1][col] &&
                !visited.contains(newPosition)) {
            maxPathLen = Math.max(maxPathLen,
                    longestPath(newPosition, new HashSet<>(visited)));
        }
        newPosition = position + maxCol;
        if (row < maxRow - 1 &&
                grid[row][col] < grid[row + 1][col] &&
                !visited.contains(newPosition)) {
            maxPathLen = Math.max(maxPathLen,
                    longestPath(newPosition, new HashSet<>(visited)));
        }

        return maxPathLen;
    }

    public int longestIncreasingPath(int[][] matrix) {
        grid = matrix;
        maxCol = grid[0].length;
        maxRow = grid.length;
        peaks = new HashSet<>();
        valleys = new HashSet<>();
        identifyPeaksAndValleys();
        int maxPath = 0;
        HashSet<Integer> visited;
        for (int position : valleys) {
            visited = new HashSet<>();
            maxPath = Math.max(maxPath, longestPath(position, visited));
        }
        return maxPath;
    }
}

public class Day410_2021 {
    public static void main(String[] args) {
        SolutionDay410 solution = new SolutionDay410();
        int[][] inputM;
        int result;

        // Example 1
        inputM = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        result = solution.longestIncreasingPath(inputM);
        System.out.println("4 == " + result);

        // Example 2
        inputM = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        result = solution.longestIncreasingPath(inputM);
        System.out.println("4 == " + result);

        // Example 3
        inputM = new int[][]{{1}};
        result = solution.longestIncreasingPath(inputM);
        System.out.println("1 == " + result);

        // Test Case 1
        inputM = new int[][]{{1,2}};
        result = solution.longestIncreasingPath(inputM);
        System.out.println("2 == " + result);
    }
}
