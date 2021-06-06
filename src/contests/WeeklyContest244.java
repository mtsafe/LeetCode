package contests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SolutionWC244 {
    boolean isSame(int[][] mat, int[][] target) {
        if (mat == null || target == null) return false;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    int[][] rotate90(int[][] mat) {
        if (mat == null) return null;
        int n = mat.length - 1;
        int[][] result = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                result[n - j][i] = mat[i][j];
            }
        }
        return result;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if (isSame(mat, target))
            return true;
        for (int i = 0; i < 4; i++) {
            mat = rotate90(mat);
            if (isSame(mat, target))
                return true;
        }
        return false;
    }
    public int reductionOperations(int[] nums) {
        if (nums==null) return 0;
        List<Integer> list = new ArrayList<>();
        for (int num:nums) list.add(num);
        Collections.sort(list);
        int step=0, stepSum=0;
        for (int i=0; i<list.size()-1; i++){
            if (list.get(i)< list.get(i+1))
                step++;
            stepSum += step;
        }
        return stepSum;
    }
}

public class WeeklyContest244 {
    public static void main(String[] args) {
        SolutionWC244 solution = new SolutionWC244();
        int[] inputN;
        int resultI;


        // Exercise 1
        inputN = new int[]{5,1,3};
        resultI = solution.reductionOperations(inputN);
        System.out.println("3 == " + resultI);

        // Exercise 2
        inputN = new int[]{1,1,1};
        resultI = solution.reductionOperations(inputN);
        System.out.println("0 == " + resultI);

        // Exercise 3
        inputN = new int[]{1,1,2,2,3};
        resultI = solution.reductionOperations(inputN);
        System.out.println("4 == " + resultI);

        ///////////////////////////////////
        int[][] inputM, inputT;
        boolean resultB;

        // Exercise 1
        inputM = new int[][]{{0, 1}, {1, 0}};
        inputT = new int[][]{{1, 0}, {0, 1}};
        resultB = solution.findRotation(inputM, inputT);
        System.out.println("true == " + resultB);

        // Exercise 2
        inputM = new int[][]{{0, 1}, {1, 1}};
        inputT = new int[][]{{1, 0}, {0, 1}};
        resultB = solution.findRotation(inputM, inputT);
        System.out.println("false == " + resultB);

        // Exercise 3
        inputM = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        inputT = new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        resultB = solution.findRotation(inputM, inputT);
        System.out.println("true == " + resultB);
    }
}
