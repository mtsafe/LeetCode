package dayChall202104;

class SolutionDay405 {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length < 3) return true;
        int maxVal = A[0];
        for (int i = 2; i < A.length; i++) {
            maxVal = Math.max(maxVal, A[i - 2]);
            if (A[i] < maxVal) return false;
        }
        return true;
    }
}

public class Day405_2021 {
    public static void main(String[] args) {
        SolutionDay405 solution = new SolutionDay405();
        int[] inputA;
        boolean result;

        // Example 1
        inputA = new int[]{1, 0, 2};
        result = solution.isIdealPermutation(inputA);
        System.out.println("true == " + result);

        // Example 2
        inputA = new int[]{1, 2, 0};
        result = solution.isIdealPermutation(inputA);
        System.out.println("false == " + result);
    }
}
