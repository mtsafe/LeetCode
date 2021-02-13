package dayChallFeb2021;

import java.util.ArrayList;

class SolutionDay113 {
    private static class Cell {
        int r, c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int breadth, depth;

    private class Visited {
        public boolean[][] v;

        Visited(int[][] grid) {
            if (grid == null) {
                depth = 0;
                breadth = 0;
                this.v = null;
                return;
            }
            depth = grid.length;
            breadth = grid[0].length;
            this.v = new boolean[depth][breadth];
            for (int i = 0; i < depth; i++)
                for (int j = 0; j < breadth; j++)
                    this.v[i][j] = grid[i][j] != 0;
        }
    }

    private Visited visited;

    private void visit(Cell cell) {
        if (cell != null)
            visited.v[cell.r][cell.c] = true;
    }

    ArrayList<Cell> getNextSteps(Cell first) {
        if (first == null)
            return null;
        ArrayList<Cell> nextSteps = new ArrayList<>();
        for (int i = first.r - 1; i <= first.r + 1; i++)
            if (i >= 0 && i < depth)
                for (int j = first.c - 1; j <= first.c + 1; j++)
                    if (j >= 0 && j < breadth)
                        if (!visited.v[i][j]) {
                            visited.v[i][j] = true;
                            nextSteps.add(new Cell(i, j));
                        }
        return nextSteps;
    }

    private ArrayList<Cell> buildNextSteps(ArrayList<Cell> nextSteps) {
        if (nextSteps == null)
            return null;
        ArrayList<Cell> nextStepsBuilder = new ArrayList<>();
        for (Cell cell : nextSteps) {
            nextStepsBuilder.addAll(getNextSteps(cell));
        }
        return nextStepsBuilder;
    }

    private void printNextSteps(ArrayList<Cell> nextSteps) {
        if (nextSteps != null)
            for (Cell cell : nextSteps) {
                System.out.print("(" + cell.r + "," + cell.c + "),");
            }
        System.out.println();
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null)
            return -1;
        visited = new Visited(grid);
        int lastRow = depth - 1;
        int lastColumn = breadth - 1;
        Cell first = new Cell(0, 0);
        int steps = 1;
        if (visited.v[0][0])
            return -1;
        else if (depth == 1 && breadth == 1)
            return steps;
        visit(first);

        ArrayList<Cell> nextSteps = getNextSteps(first);
        while (nextSteps.size() > 0) {
            printNextSteps(nextSteps);
            steps++;
            for (Cell cell : nextSteps) {
                if (cell.r == lastRow && cell.c == lastColumn)
                    return steps;
            }
            nextSteps = buildNextSteps(nextSteps);
        }
        return -1;
    }
}

public class Day113_2021 {
    public static void main(String[] args) {
        SolutionDay113 solution = new SolutionDay113();
        int[][] input;
        int result;

        // Trivial 1
        input = new int[][]{{0}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("1 == " + result);

        // Trivial 2
        input = new int[][]{{1}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("-1 == " + result);

        // Trivial 3
        input = new int[][]{{0, 0}, {0, 0}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("2 == " + result);

        // Trivial 4
        input = new int[][]{{0, 0}, {0, 1}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("-1 == " + result);

        // Example 1
        input = new int[][]{{0, 1}, {1, 0}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("2 == " + result);

        // Example 2
        input = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("4 == " + result);

        // Testcase 1
        input = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        result = solution.shortestPathBinaryMatrix(input);
        System.out.println("-1 == " + result);
    }
}
