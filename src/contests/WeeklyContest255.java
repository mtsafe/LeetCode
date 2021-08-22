package contests;

import java.util.ArrayList;
import java.util.Collections;

class SolutionWC255 {
    public int findGCD(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int least = Integer.MAX_VALUE, most = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i < least) least = i;
            if (i > most) most = i;
        }
        for (int i = least; i > 1; i--)
            if (least % i == 0 && most % i == 0) return i;
        return 1;
    }

    int binToInt(String bin) {
        if (bin == null) return 0;
        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.toCharArray()[i] == '1')
                result += Math.pow(2, i);
        }
        return result;
    }

    String intToBin(int a, int len) {
        int bit;
        String result = "";
        for (int i = 0; i < len; i++) {
            bit = (int) Math.pow(2, i);
            if ((a & bit) == bit)
                result += "1";
            else
                result += "0";
        }
        return result;
    }

    public String findDifferentBinaryString(String[] nums) {
        if (nums == null) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : nums)
            list.add(binToInt(s));
        Collections.sort(list);
        int max = (int) Math.pow(2, nums[0].length());
        for (int i = 0; i < max; i++) {
            if (i >= list.size() || i != list.get(i))
                return intToBin(i, nums[0].length());
        }
        return "";
    }

    /* Sort each row then start with the first column and search like a tree */
    void sortRows(int[][] mat) {
        int rowLen = mat[0].length;
        for (int j = 0; j < mat.length; j++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < rowLen; i++)
                list.add(mat[j][i]);
            Collections.sort(list);
            for (int i = 0; i < rowLen; i++)
                mat[j][i] = list.get(i);
        }
    }

    int minDiff(int[][] mat, int row,int sum, int target, int best) {
        if (mat == null) return 0;
        if (row+1==mat.length) {
            sum+=mat[row][0];
        }
        return sum;
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        if (mat == null) return 0;
        sortRows(mat);
        return minDiff(mat, 0,0,target, Integer.MAX_VALUE);
    }
}

public class WeeklyContest255 {
    public static void main(String[] args) {
        SolutionWC255 solution = new SolutionWC255();
        int[][] inputIAA;
        int inputI;
        int resultI;

        // Example 1
        inputIAA = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        inputI = 13;
        resultI = solution.minimizeTheDifference(inputIAA, inputI);
        System.out.println("0 == " + resultI);

        // Example 2
        inputIAA = new int[][]{{1}, {2}, {3}};
        inputI = 100;
        resultI = solution.minimizeTheDifference(inputIAA, inputI);
        System.out.println("940 == " + resultI);

        // Example 3
        inputIAA = new int[][]{{1}, {2}, {9}, {8}, {7}};
        inputI = 6;
        resultI = solution.minimizeTheDifference(inputIAA, inputI);
        System.out.println("1 == " + resultI);

        /////////////////////////////////////////////
        String[] inputSA;
        String resultS;

        // Example 1
        inputSA = new String[]{"01", "10"};
        resultS = solution.findDifferentBinaryString(inputSA);
        System.out.println("11 == " + resultS);

        // Example 2
        inputSA = new String[]{"00", "01"};
        resultS = solution.findDifferentBinaryString(inputSA);
        System.out.println("11 == " + resultS);

        // Example 3
        inputSA = new String[]{"111", "011", "001"};
        resultS = solution.findDifferentBinaryString(inputSA);
        System.out.println("101 == " + resultS);

        // Test Case 1
        inputSA = new String[]{"0"};
        resultS = solution.findDifferentBinaryString(inputSA);
        System.out.println("1 == " + resultS);

        /////////////////////////////////////////////
        int[] inputIA;

        // Example 1
        inputIA = new int[]{2, 5, 6, 9, 10};
        resultI = solution.findGCD(inputIA);
        System.out.println("2 == " + resultI);

        // Example 2
        inputIA = new int[]{7, 5, 6, 8, 3};
        resultI = solution.findGCD(inputIA);
        System.out.println("1 == " + resultI);

        // Example 2
        inputIA = new int[]{3, 3};
        resultI = solution.findGCD(inputIA);
        System.out.println("3 == " + resultI);
    }
}
