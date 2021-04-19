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


    int[][] memo;

    void initializeMemo(int rows, int cols) {
        // prefix sum the rows
        memo = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            memo[i][0] = globalMatrix[i][0];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                memo[i][j] = memo[i][j - 1] + globalMatrix[i][j];
            }
        }
    }

    int calcSum(int i, int j, int a, int b) {
        int sum = 0;
        if (j == 0)
            for (int m = i; m <= a; m++)
                sum += memo[m][b];
        else
            for (int m = i; m <= a; m++)
                sum += memo[m][b] - memo[m][j - 1];
        return sum;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null) return 0;
        globalMatrix = matrix;
        int rows = matrix.length, cols = matrix[0].length;
//        initializeMemo_2ndTry(rows,cols);
        initializeMemo(rows, cols);
        int bullsEyes = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int a = i; a < rows; a++) {
                    for (int b = j; b < cols; b++) {
//                        if (calcSum_2ndTry(i, j, a, b) == target) bullsEyes++;
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
        // Trivial 1
        inputM = new int[][]{{0, 1}};
        inputT = 0;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("1 == " + result);

        // Trivial 2
        inputM = new int[][]{{0, 1}};
        inputT = 1;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("2 == " + result);

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

        // Test Case 1
        inputM = new int[][]{{0, 1, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 0}};
        inputT = 0;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("43 == " + result);

        // Test Case 2
        inputM = new int[][]{
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0}};
        inputT = 1;
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("47 == " + result);

        // Test Case 2
        inputM = new int[81][81];
        inputT = -12348;
        for (int i = 0; i < 81; i++) {
            for (int j = 0; j < 81; j++) {
                inputM[i][j] = -84;
            }
        }
        result = solution.numSubmatrixSumTarget(inputM, inputT);
        System.out.println("14364 == " + result);

        // Big Test 1
        inputM = new int[99][99];
        inputT = 0;
//        for (int i = 0; i < 99; i++) {
//            for (int j = 0; j < 33; j++) {
//                inputM[i][3 * j] = -1;
//                inputM[i][3 * j + 1] = 0;
//                inputM[i][3 * j + 2] = 1;
//            }
//        }
//        result = solution.numSubmatrixSumTarget(inputM, inputT);
//        System.out.println("13394700 == " + result);

        theTime1 = System.currentTimeMillis();
        System.out.println("time == " + (theTime1 - theTime0));
    }
}
