package dayChallApr2021;

class SolutionDay417 {
    int[][] globalMatrix;
    int[][][] memo;
    boolean[][][] memoized;

    int calcSum_1stTry(int i, int j, int a, int b) {
        int sum = 0;
        for (int m = i; m <= a; m++) {
            for (int n = j; n <= b; n++) {
                sum += globalMatrix[m][n];
            }
        }
        return sum;
    }

    void initializeMemo(int rows, int cols) {
        memo = new int[rows][cols][cols];
        memoized = new boolean[rows][cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    memoized[i][j][k] = false;
                }
            }
        }
    }

    void memoize(int row, int colFirst, int colLast) {
        if (colFirst < colLast) {
            if (!memoized[row][colFirst][colLast - 1])
                memoize(row, colFirst,colLast - 1);
            memo[row][colFirst][colLast] =
                    memo[row][colFirst][colLast - 1] +
                            globalMatrix[row][colLast];
        } else if (colFirst == colLast) {
            memo[row][colFirst][colLast] = globalMatrix[row][colLast];
        } else {
            memo[row][colFirst][colLast] = 0;
        }
        memoized[row][colFirst][colLast] = true;
    }

    int calcSum(int i, int j, int a, int b) {
        int sum = 0;
        for (int m = i; m <= a; m++) {
            if (!memoized[m][j][b])
                memoize(m, j, b);
            sum += memo[m][j][b];
            /*
            for (int n = j; n <= b; n++) {
                sum += globalMatrix[m][n];
            }
             */
        }
        return sum;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null) return 0;
        globalMatrix = matrix;
        int rows = matrix.length, cols = matrix[0].length;
        initializeMemo(rows, cols);
        int bullsEyes = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int a = i; a < rows; a++) {
                    for (int b = j; b < cols; b++) {
                        System.out.println("calcSum("+i+", "+j+", "+a+", "+b+") == "+
                                calcSum(i, j, a, b));
                        if (calcSum(i, j, a, b) == target) bullsEyes++;
                    }
                }
            }
        }
        return bullsEyes;
    }
}

public class Day417_2021 {
    public static void main(String[] args) {
        SolutionDay417 solution = new SolutionDay417();
        int[][] inputM;
        int inputT;
        int result;
        long theTime0, theTime1;

        theTime0 = System.currentTimeMillis();
        // Example 1
        inputM = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        inputT = 0;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("4 == " + result);

        // Example 2
        inputM = new int[][]{{1, -1}, {-1, 1}};
        inputT = 0;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("5 == " + result);

        // Example 3
        inputM = new int[][]{{904}};
        inputT = 0;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("0 == " + result);

        theTime1 = System.currentTimeMillis();
        System.out.println("time == "+(theTime1-theTime0));
    }
}
