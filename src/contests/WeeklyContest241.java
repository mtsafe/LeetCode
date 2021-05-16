package contests;

import java.util.ArrayList;
import java.util.List;

class SolutionWC241 {
    int xOrArr(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return 0;
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result ^= arr.get(i);
        }
        return result;
    }

    private void helper(List<List<Integer>> combinations, List<Integer> data, int start, int end, int index) {
        if (index == data.size()) {
            List<Integer> combination = new ArrayList<Integer>(data);
            combinations.add(combination);
        } else if (start <= end) {
            data.add(index, start);
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public List<List<Integer>> generate(int n, int r) {
        List<List<Integer>> combinations = new ArrayList<>();
        helper(combinations, new ArrayList<>(r), 0, n - 1, 0);
        return combinations;
    }

    List<List<Integer>> makeArr(int[] arr, int x) {
        return new ArrayList<>();
    }

    List<List<Integer>> makeArr_1stTry(int[] arr, int x) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list0.add(arr[i]);
        }
        result.add(list0);
        List<List<Integer>> tmpResult;
        List<Integer> tmpList;
        for (int y = 0; y < x; y++) {
            tmpResult = new ArrayList<>();
            for (List<Integer> list : result) {
                for (int i = 0; i < list.size(); i++) {
                    tmpList = new ArrayList<Integer>(list);
                    tmpList.remove(i);
                    tmpResult.add(tmpList);
                }
            }
            result = tmpResult;
        }
        return result;
    }

    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int x = 0; x < nums.length; x++) {
            for (List<Integer> arr : makeArr(nums, x)) {
                sum += xOrArr(arr);
                System.out.println("sum == " + sum + "; list == " + arr.toString());
            }
        }
        return sum;
    }

    public int minSwaps(String s) {
        if (s == null) return 0;
        int[] even = new int[2], odd = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i % 2 == 0) even[0]++;
                else odd[0]++;
            } else {
                if (i % 2 == 0) even[1]++;
                else odd[1]++;
            }
        }
        if (even[0] + odd[0] == even[1] + odd[1]) {
            return Math.min(odd[0],odd[1]);
        } else if (even[0] + odd[0] == even[1] + odd[1] + 1) {
            if (odd[0]==even[1]) return odd[0];
        } else if (even[0] + odd[0] + 1 == even[1] + odd[1]) {
            if (odd[1]==even[0]) return odd[1];
        }
        return -1;
    }
}

public class WeeklyContest241 {
    public static void main(String[] args) {
        SolutionWC241 solution = new SolutionWC241();
        String inputS;
        int result;

        // Example 1
        inputS = "111000";
        result = solution.minSwaps(inputS);
        System.out.println("1 == " + result);

        // Example 2
        inputS = "010";
        result = solution.minSwaps(inputS);
        System.out.println("0 == " + result);

        // Example 1
        inputS = "1110";
        result = solution.minSwaps(inputS);
        System.out.println("-1 == " + result);

        ///////////////////
        int[] inputN;

        // Example 1
        inputN = new int[]{1, 3};
        result = solution.subsetXORSum(inputN);
        System.out.println("6 == " + result);

        // Example 2
        inputN = new int[]{5, 1, 6};
        result = solution.subsetXORSum(inputN);
        System.out.println("28 == " + result);
//
//        // Example 3
//        inputN = new int[]{3, 4, 5, 6, 7, 8};
//        result = solution.subsetXORSum(inputN);
//        System.out.println("480 == " + result);
    }
}
