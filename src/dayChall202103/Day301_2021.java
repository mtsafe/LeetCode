package dayChall202103;

import java.util.HashSet;

class SolutionDay301 {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> hash = new HashSet<>();
        int stop = candyType.length;
        for (int i = 0; i < stop; i++) {
            if (!hash.contains(candyType[i]))
                hash.add(candyType[i]);
            if (2 * i >= stop && 2 * hash.size() >= stop)
                break;
        }
        return Math.min(hash.size(), stop / 2);
    }
}

public class Day301_2021 {
    public static void main(String[] args) {
        SolutionDay301 solution = new SolutionDay301();
        int[] input;
        int result;

        // Example 1
        input = new int[]{1, 1, 2, 2, 3, 3};
        result = solution.distributeCandies(input);
        System.out.println("3 == " + result);

        // Example 2
        input = new int[]{1, 1, 2, 3};
        result = solution.distributeCandies(input);
        System.out.println("2 == " + result);

        // Example 3
        input = new int[]{6, 6, 6, 6};
        result = solution.distributeCandies(input);
        System.out.println("1 == " + result);
    }
}
