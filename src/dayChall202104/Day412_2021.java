package dayChall202104;

import java.util.Arrays;

class SolutionDay412 {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        if (n < 2 || k >= n) return result;
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                result[i] = i + 1;
            }
            return result;
        }
        for (int i = 0; i <= k; i++) {
            result[i] = i % 2 == 0 ? i / 2 + 1 : k + 2 - result[i - 1];
        }
        for (int i = k + 1; i < n; i++) {
//            result[i] = k % 2 == 0 ? i + 1 : i+1;
            result[i] = i + 1;
        }
        return result;
    }
}

public class Day412_2021 {
    public static void main(String[] args) {
        SolutionDay412 solution = new SolutionDay412();
        int inputN, inputK;
        int[] result;

        // Example 1
        inputN = 3;
        inputK = 1;
        result = solution.constructArray(inputN, inputK);
        System.out.println("[1,2,3] == " + Arrays.toString(result));

        // Example 2
        inputN = 3;
        inputK = 2;
        result = solution.constructArray(inputN, inputK);
        System.out.println("[1,3,2] == " + Arrays.toString(result));
    }
}
