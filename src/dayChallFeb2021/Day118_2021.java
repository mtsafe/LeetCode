package dayChallFeb2021;

import java.util.HashMap;

class SolutionDay118 {
    private void addSeqToHash(HashMap<Integer, Integer> hash, int seq) {
        if (seq < 1 || hash == null)
            return;
        if (hash.get(seq) == null) {
            hash.put(seq, 1);
            return;
        }
        hash.replace(seq, hash.get(seq) + 1);
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int seq = 0;
        int step = A[1] - A[0];
        int prev = A[1];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - prev == step) {
                seq++;
                if (i == A.length - 1)
                    addSeqToHash(hash, seq);
            } else {
                addSeqToHash(hash, seq);
                seq = 0;
                step = A[i] - prev;
            }
            prev = A[i];
        }
        int sum = 0;
        for (int key: hash.keySet()) {
            sum += hash.get(key) * key*(key+1)/2;
        }
        return sum;
    }
}

public class Day118_2021 {
    public static void main(String[] args) {
        SolutionDay118 solution = new SolutionDay118();
        int[] input;
        int result;

        // Trivial 1
        input = null;
        result = solution.numberOfArithmeticSlices(input);
        System.out.println("0 == " + result);

        // Trivial 2
        input = new int[]{1, 2};
        result = solution.numberOfArithmeticSlices(input);
        System.out.println("0 == " + result);

        // Trivial 3
        input = new int[]{1, 2, 3};
        result = solution.numberOfArithmeticSlices(input);
        System.out.println("1 == " + result);

        // Trivial 4
        input = new int[]{1, 2, 3, 10};
        result = solution.numberOfArithmeticSlices(input);
        System.out.println("1 == " + result);

        // Example 1
        input = new int[]{1, 2, 3, 4};
        result = solution.numberOfArithmeticSlices(input);
        System.out.println("3 == " + result);
    }
}
