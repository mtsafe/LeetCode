package contests;

import java.util.Arrays;
import java.util.HashMap;

class SolutionWC226 {
    private int boxNum(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public int countBalls(int lowLimit, int highLimit) {
        int totalBalls = highLimit - lowLimit + 1;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            if (hash.containsKey(boxNum(i)))
                hash.put(boxNum(i), hash.get(boxNum(i)) + 1);
            else
                hash.put(boxNum(i), 1);
        }
        int[] arr = new int[hash.values().size()];
        int maxBallCnt = 0;
        int maxBallCntBox = 0;
        for (int box : hash.keySet()) {
            if (hash.get(box) > maxBallCnt) {
                maxBallCnt = hash.get(box);
                maxBallCntBox = box;
            }
        }
        return maxBallCnt;
    }

    class RANode {
        int val;
        RANode left;
        RANode right;
        RANode() {}
        RANode(int val) { this.val = val; }
        RANode(int val, RANode right) { this.val = val; this.left = right; }
        RANode(int val, int valRight) {
            this.val = val; this.right = new RANode(valRight);
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, RANode>hash = new HashMap<>();
        RANode head;
        RANode tail;
        int val1, val2;
        val1 = adjacentPairs[0][0];
        val2 = adjacentPairs[0][1];
        head = new RANode(val1, val2);
        tail = head.right;
        hash.put(val1, head);
        hash.put(val2, tail);
        RANode raTmp1, raTmp2;
        for (int i = 1; i < adjacentPairs.length; i++) {
            val1 = adjacentPairs[0][0];
            val2 = adjacentPairs[0][1];
            if (hash.containsKey(val1)) {
                raTmp1 = hash.get(val1);
                if (hash.containsKey(val2)) {
                    raTmp2 = hash.get(val2);
                    if (raTmp1.right == null && raTmp2.left == null) {
                        raTmp1.right = raTmp2;
                        raTmp2.left = raTmp1;
                    } else if (raTmp1.left == null && raTmp2.right == null) {
                        raTmp1.left = raTmp2;
                        raTmp2.right = raTmp1;
                    } else {
                        System.out.println("Bad RA Build 0");
                        return null;
                    }
                }
            }
        }
        return new int[] {0,1};
    }
}

public class WeeklyContest226 {
    public static void main(String[] args) {
        SolutionWC226 solution = new SolutionWC226();
        int input;
        int lowLimit, highLimit;
        int[][] input2d;
        int result;
        int[] result1d;

        /////////////////// restoreArray
        System.out.println("--- restoreArray ---");
        // Test
        input2d = new int[][]{{2,3},{2,1}};
        result1d = solution.restoreArray(input2d);
        System.out.println("[3,2,1] == "+ Arrays.toString(result1d));

        // Example 1
        input2d = new int[][]{{2,1},{3,4},{3,2}};
        result1d = solution.restoreArray(input2d);
        System.out.println("[1,2,3,4] == "+ Arrays.toString(result1d));

        // Example 2
        input2d = new int[][]{{4,-2},{1,4},{-3,1}};
        result1d = solution.restoreArray(input2d);
        System.out.println("[-2,4,1,-3] == "+ Arrays.toString(result1d));

        // Example 3
        input2d = new int[][]{{100000,-100000}};
        result1d = solution.restoreArray(input2d);
        System.out.println("[100000,-100000] == "+ Arrays.toString(result1d));

        /////////////////// countBalls
        System.out.println("--- countBalls ---");
        // Test
        lowLimit = 1;
        highLimit = 1;
        result = solution.countBalls(lowLimit, highLimit);
        System.out.println("1 == " + result);

        // Example 1
        lowLimit = 1;
        highLimit = 10;
        result = solution.countBalls(lowLimit, highLimit);
        System.out.println("2 == " + result);

        // Example 2
        lowLimit = 5;
        highLimit = 15;
        result = solution.countBalls(lowLimit, highLimit);
        System.out.println("2 == " + result);

        // Example 3
        lowLimit = 19;
        highLimit = 28;
        result = solution.countBalls(lowLimit, highLimit);
        System.out.println("2 == " + result);
    }
}
