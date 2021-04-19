package dayChall202104;

class SolutionDay417 {
    int[][] globalMatrix;

    int calcSum_1stTry(int i, int j, int a, int b) {
        int sum = 0;
        for (int m = i; m <= a; m++) {
            for (int n = j; n <= b; n++) {
                sum += globalMatrix[m][n];
            }
        }
        return sum;
    }

    int[][][] memoRows;
    boolean[][][] memoizedRows;

    void initializeMemo_2ndTry(int rows, int cols) {
        memoRows = new int[rows][cols][cols];
        memoizedRows = new boolean[rows][cols][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                for (int k = 0; k < cols; k++) {
//                    memoizedRows[i][j][k] = false;
//                }
//            }
//        }
    }

    void memoize_2ndTry(int row, int colFirst, int colLast) {
        if (colFirst < colLast) {
            if (!memoizedRows[row][colFirst][colLast - 1])
                memoize_2ndTry(row, colFirst, colLast - 1);
            memoRows[row][colFirst][colLast] =
                    memoRows[row][colFirst][colLast - 1] +
                            globalMatrix[row][colLast];
        } else if (colFirst == colLast) {
            memoRows[row][colFirst][colLast] = globalMatrix[row][colLast];
        } else {
            memoRows[row][colFirst][colLast] = 0;
        }
        memoizedRows[row][colFirst][colLast] = true;
    }

    int calcSum_2ndTry(int i, int j, int a, int b) {
        int sum = 0;
        for (int m = i; m <= a; m++) {
            if (!memoizedRows[m][j][b])
                memoize_2ndTry(m, j, b);
            sum += memoRows[m][j][b];
        }
        return sum;
    }


    int[][][][] memo;
    boolean[][][][] memoized;

    void initializeMemo(int rows, int cols) {
        memo = new int[rows][cols][rows][cols];
        memoized = new boolean[rows][cols][rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int a = 0; a < cols; a++) {
                    for (int b = 0; b < cols; b++) {
                        memoized[i][j][a][b] = false;
                    }
                }
            }
        }
    }

    void memoizeRow(int row, int colFirst, int colLast) {
        if (colFirst < colLast) {
            if (!memoized[row][colFirst][row][colLast - 1])
                memoizeRow(row, colFirst, colLast - 1);
            memo[row][colFirst][row][colLast] =
                    memo[row][colFirst][row][colLast - 1] +
                            globalMatrix[row][colLast];
        } else if (colFirst == colLast) {
            memo[row][colFirst][row][colLast] = globalMatrix[row][colLast];
        } else {
            memo[row][colFirst][row][colLast] = 0;
        }
        memoized[row][colFirst][row][colLast] = true;
    }

    int calcSum(int i, int j, int a, int b) {
        int sum = 0;
        for (int m = i; m <= a; m++) {
            if (!memoized[m][j][m][b])
                memoizeRow(m, j, b);
            sum += memo[m][j][m][b];
        }
        return sum;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null) return 0;
        globalMatrix = matrix;
        int rows = matrix.length, cols = matrix[0].length;
        initializeMemo_2ndTry(rows, cols);
        int bullsEyes = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int a = i; a < rows; a++) {
                    for (int b = j; b < cols; b++) {
//                        System.out.println("calcSum("+i+", "+j+", "+a+", "+b+") == "+
//                                calcSum(i, j, a, b));
                        if (calcSum_2ndTry(i, j, a, b) == target) bullsEyes++;
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

        // Big Test 1
        inputM = new int[99][99];
        inputT = 0;
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 33; j++) {
                inputM[i][3 * j] = -1;
                inputM[i][3 * j + 1] = 0;
                inputM[i][3 * j + 2] = 1;
            }
        }
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("13394700 == " + result);

        theTime1 = System.currentTimeMillis();
        System.out.println("time == " + (theTime1 - theTime0));
    }
}
