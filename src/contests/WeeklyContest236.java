package contests;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class SolutionWC236 {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i < 0) sign *= -1;
        }
        return sign;
    }

    public int findTheWinner(int n, int k) {
        List<Integer> circle = new Stack<>();
        for (int i = 0; i < n; i++) circle.add(i);
        int start = 0;
        while (circle.size() > 1) {
            start = (start + k - 1) % circle.size();
            circle.remove(start);
        }
        return circle.get(0) + 1;
    }

    int[] obstaclePos;

    boolean isObstacle(int lane_1, int point) {
        return lane_1 + 1 == obstaclePos[point];
    }

    public int minSideJumps(int[] obstacles) {
        if (obstacles == null) return 0;
        obstaclePos = obstacles;
        int maxLen = obstacles.length;
        int[][] positions = new int[3][maxLen];
        for (int i = 0; i < 3; i++) {
            if (isObstacle(i, maxLen - 1))
                positions[i][maxLen - 1] = 0;
            else
                positions[i][maxLen - 1] = 1;
        }
        for (int j = maxLen - 2; j >= 0; j--) {
            for (int i = 0; i < 3; i++) {
                if (isObstacle(i, j)) {
                    positions[i][j] = 0;
                    continue;
                }
                if (positions[i][j + 1] == 0) {
                    if (i == 0) {
                        if (isObstacle(1, j)) {
                            positions[0][j] = positions[2][j + 1] + 2;
                            continue;
                        }
                        positions[0][j] = positions[1][j + 1] + 2;
                    } else if (i == 2) {
                        if (isObstacle(1, j)) {
                            positions[2][j] = positions[0][j + 1] + 2;
                            continue;
                        }
                        positions[2][j] = positions[1][j + 1] + 2;
                    } else {
                        if (isObstacle(0, j)) {
                            positions[1][j] = positions[2][j + 1] + 2;
                            continue;
                        }
                        if (isObstacle(2, j)) {
                            positions[1][j] = positions[0][j + 1] + 2;
                            continue;
                        }
                        positions[1][j] = Math.min(positions[0][j + 1],
                                positions[2][j + 1]) + 2;
                    }
                    continue;
                }
                positions[i][j] = positions[i][j + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(positions[0]));
        System.out.println(Arrays.toString(positions[1]));
        System.out.println(Arrays.toString(positions[2]));
        return positions[1][0] - maxLen;
    }
}

public class WeeklyContest236 {
    public static void main(String[] args) {
        SolutionWC236 solution = new SolutionWC236();
        int[] inputO;
        int result;

        // Example 1
        inputO = new int[]{0, 1, 2, 3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("2 == " + result);

        // Example 2
        inputO = new int[]{0, 1, 1, 3, 3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("0 == " + result);

        // Example 3
        inputO = new int[]{0, 2, 1, 0, 3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("2 == " + result);

        // Test Case 1
        inputO = new int[]{0, 3, 3, 0, 3, 2, 2, 0, 0, 3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("1 == " + result);

        // Test Case 2
        inputO = new int[]{0};
        result = solution.minSideJumps(inputO);
        System.out.println("0 == " + result);

        // Test Case 3
        inputO = new int[]{3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("0 == " + result);

        // Test Case 4
        inputO = new int[]{0, 3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("0 == " + result);

        // Test Case 5
        inputO = new int[]{0, 2, 1, 0, 3, 0};
        result = solution.minSideJumps(inputO);
        System.out.println("2 == " + result);

        // Test Case 5
        inputO = new int[]{
                0,2,2,1,0,3,0,3,0,1,3,1,1,0,1,3,1,1,1,0,2,0,0,3,3,0,
                3,2,2,0,0,3,3,3,0,0,2,0,0,3,3,0,3,3,0,0,3,1,0,1,0,2,
                3,1,1,0,3,3,0,3,1,3,0,2,2,0,1,3,0,1,0,3,0,1,3,1,2,2,
                0,0,3,0,1,3,2,3,2,1,0,3,2,2,0,3,3,0,3,0,0,1,0
        };
        result = solution.minSideJumps(inputO);
        System.out.println("14 == " + result);

        // Test Case 6
        inputO = new int[]{
                0,0,3,0,1,3,2,3,2,1,0,3,2,2,0,3,3,0,3,0,0,1,0
        };
        result = solution.minSideJumps(inputO);
        System.out.println("5 == " + result);

        // Test Case 7
        inputO = new int[]{
                0,1,3,0,1,0,3,0,1,3,1,2,2
        };
        result = solution.minSideJumps(inputO);
        System.out.println("14 == " + result);

        // Test Case 7
        inputO = new int[]{
                3,1,1,0,3,3,0,3,1,3,0,2,2
        };
        result = solution.minSideJumps(inputO);
        System.out.println("14 == " + result);

        // Test Case 8
        inputO = new int[]{
                3,2,2,0,0,3,3,3,0,0,2,0
        };
        result = solution.minSideJumps(inputO);
        System.out.println("14 == " + result);

        // Test Case 9
        inputO = new int[]{
                0,3,3,0,3,3,0,0,3,1,0,1,0,2
        };
        result = solution.minSideJumps(inputO);
        System.out.println("14 == " + result);

        // Test Case 10
        inputO = new int[]{
                0,2,2,1,0,3,0,3,0,1,3,1,1
        };
        result = solution.minSideJumps(inputO);
        System.out.println("2 == " + result);

        // Test Case 11
        inputO = new int[]{
                0,1,3,1,1,1,0,2,0,0,3,3,0,
        };
        result = solution.minSideJumps(inputO);
        System.out.println("1 == " + result);
    }
}
