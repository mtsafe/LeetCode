package dayChallFeb2021;

import java.util.HashMap;

class SolutionDay104 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num: nums) {
            if (hash.containsKey(num))
                hash.replace(num, hash.get(num) + 1);
            else
                hash.put(num, 1);
        }

        int maxSS = 0;
        for (int key: hash.keySet()) {
            if (hash.containsKey(key + 1)) {
                maxSS = Math.max(maxSS, hash.get(key) + hash.get(key + 1));
            }
        }
        return maxSS;
    }
}

public class Day104_2021 {
    public static void main(String[] args) {
        SolutionDay104 solution = new SolutionDay104();
        int[] input;
        int result;

        // Trivial 1
        input = new int[] {};
        result = solution.findLHS(input);
        System.out.println("0 == "+result);

        // Trivial 2
        input = new int[] {4};
        result = solution.findLHS(input);
        System.out.println("1 == "+result);

        // Example 1
        input = new int[] {1,3,2,2,5,2,3,7};
        result = solution.findLHS(input);
        System.out.println("5 == "+result);

        // Example 2
        input = new int[] {1,2,3,4};
        result = solution.findLHS(input);
        System.out.println("2 == "+result);

        // Example 3
        input = new int[] {1,1,1,1};
        result = solution.findLHS(input);
        System.out.println("0 == "+result);
    }
}
