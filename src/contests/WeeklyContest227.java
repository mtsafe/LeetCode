package contests;

import java.util.Arrays;

class SolutionWC227 {
    public boolean check(int[] nums) {
        int cnt = 0;
        if (nums[0] < nums[nums.length - 1])
            cnt++;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > nums[i + 1])
                cnt++;
            if (cnt > 1)
                return false;
        }
        return true;
    }

    public int maximumScore(int a, int b, int c) {
        int score = 0;
        while ((a != 0 || b != 0) && (b != 0 || c != 0) && (a != 0 || c != 0)) {
            if (a > b) {
                if (b > c) {
                    a--;
                    b--;
                    score++;
                } else {
                    a--;
                    c--;
                    score++;
                }
            } else if (a > c) {
                a--;
                b--;
                score++;
            } else {
                b--;
                c--;
                score++;
            }
        }
        return score;
    }

    private int mergePart(char[] arr1, char[] arr2, int pos1, int pos2) {
        int shift = 0;
        while (arr1[pos1+shift] == arr2[pos2+shift]) {
            shift++;
        }
        if (arr1[pos1+shift] > arr2[pos2+shift])
            return shift;
        return -shift;
    }

    public String largestMerge(String word1, String word2) {
        String merge = "";
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int aL1 = arr1.length;
        int aL2 = arr2.length;
        int start1 = 0;
        int start2 = 0;
        int nixer;
        while (aL1 > start1 && aL2 > start2) {
            nixer = mergePart(arr1, arr2, start1, start2);
            if (nixer > 0) {
                merge += "a";
            }
            return merge;
        }
        return merge;
    }
}

public class WeeklyContest227 {
    public static void main(String[] args) {
        SolutionWC227 solution = new SolutionWC227();
        int[] input;
        boolean result;

        // Trivial 1
        input = new int[]{3};
        result = solution.check(input);
        System.out.println("" + Arrays.toString(input));

        // Example 1
        input = new int[]{3, 4, 5, 1, 2};
        result = solution.check(input);
        System.out.println("" + Arrays.toString(input));

        // Example 2
        input = new int[]{2, 1, 3, 4};
        result = solution.check(input);
        System.out.println("" + Arrays.toString(input));

        // Example 3
        input = new int[]{1, 2, 3};
        result = solution.check(input);
        System.out.println("" + Arrays.toString(input));

        // Example 4
        input = new int[]{1, 1, 1};
        result = solution.check(input);
        System.out.println("" + Arrays.toString(input));

        // Example 5
        input = new int[]{2, 1};
        result = solution.check(input);
        System.out.println("" + Arrays.toString(input));
    }
}
