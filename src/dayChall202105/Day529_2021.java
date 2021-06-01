package dayChall202105;

class SolutionDay529 {
    class GridQ {
        int[][] grid;
        int n;

        GridQ(int n) {
            this.n = n;
            grid = new int[n][n];
        }

        GridQ(GridQ gQ) {
            if (gQ == null) {
                grid = new int[0][0];
                return;
            }
            grid = new int[gQ.n][gQ.n];
            this.n = gQ.n;
            for (int i = 0; i < n; i++) {
                System.arraycopy(gQ.grid[i], 0, this.grid[i], 0, n);
            }
        }

        int place(int x, int y) {
            if (x >= n || y >= n) return 0;
            if (grid[x][y] != 0) return 0;
            for (int i = 0; i < n - x; i++) {
                if (x + i < n) {
                    grid[x + i][y] = 1;
                    if (y + i < n) grid[x + i][y + i] = 1;
                    if (y - i >= 0) grid[x + i][y - i] = 1;
                }
            }
            System.out.println("placed (" + x + ", " + y + ")");
            return 1;
        }
    }

    int recurseNQ(GridQ gQ, int row) {
        System.out.println("row == " + row);
        if (gQ == null) return 0;
        if (row >= gQ.n) return 1;
        int result = 0;
        for (int i = 0; i < gQ.n; i++) {
            GridQ q = new GridQ(gQ);
            System.out.println("try (" + row + ", " + i + ")");
            if (q.place(row, i) == 1) {
                result += recurseNQ(q, row + 1);
            }
        }
        return result;
    }

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            GridQ gQ = new GridQ(n);
            gQ.place(0, i);
            result += recurseNQ(gQ, 1);
        }
        return result;
    }
}

public class Day529_2021 {
    public static void main(String[] args) {
        SolutionDay529 solution = new SolutionDay529();
        int inputN;
        int resultI;

        // Example 1
        inputN = 4;
        resultI = solution.totalNQueens(inputN);
        System.out.println("\n2 == " + resultI);

        // Example 2
        inputN = 1;
        resultI = solution.totalNQueens(inputN);
        System.out.println("\n1 == " + resultI);

        // Test case 1
        inputN = 2;
        resultI = solution.totalNQueens(inputN);
        System.out.println("\n0 == " + resultI);

        // Test case 2
        inputN = 3;
        resultI = solution.totalNQueens(inputN);
        System.out.println("\n0 == " + resultI);
    }
}
