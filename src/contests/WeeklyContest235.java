package contests;

import java.util.*;

class SolutionWC235 {
    public String truncateSentence(String s, int k) {
        char[] chars = s.toCharArray();
        int spaceCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                spaceCnt++;
                if (spaceCnt == k)
                    break;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    HashSet<Integer> idSet;
    HashMap<Integer, HashSet<Integer>> hash2Set;

    void buildUAMData(int[][] logs, int k) {
        idSet = new HashSet<>();
        hash2Set = new HashMap<>();
        int key;
        for (int[] log : logs) {
            key = log[0];
            idSet.add(key);
            if (!hash2Set.containsKey(key))
                hash2Set.put(key, new HashSet<>());
            hash2Set.get(key).add(log[1]);
        }
    }

    void calcUAMs(int[] result, int k) {
        int uam;
        for (int user : new ArrayList<>(idSet)) {
            uam = hash2Set.get(user).size();
            if (uam > k) continue;
            result[uam - 1] += 1;
        }
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        buildUAMData(logs, k);
        int[] result = new int[k];
        calcUAMs(result, k);
        return result;
    }

    int absoluteSumDiff(int[] nums1, int[] nums2) {
        long asd = 0;
        for (int i = 0; i < nums1.length; i++) {
            asd += Math.abs(nums1[i] - nums2[i]);
        }
        return (int) (asd % 1000000007);
    }

    HashMap<Integer, List<Integer>> diffMap;
    List<Integer> diffList;

    void buildData(int[] nums1, int[] nums2) {
        diffMap = new HashMap<>();
        int diff;
        for (int i = 0; i < nums1.length; i++) {
            diff = Math.abs(nums1[i] - nums2[i]);
            if (diff == 0) continue;
            if (!diffMap.containsKey(diff))
                diffMap.put(diff, new ArrayList<>());
            diffMap.get(diff).add(i);
        }
        diffList = new ArrayList<>(diffMap.keySet());
        Collections.sort(diffList);
        Collections.reverse(diffList);
    }

    int[] makeMaxChange(int[] nums1, int[] nums2) {
        if (diffList.size() == 0) return nums1;
        return nums1;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        buildData(nums1, nums2);
        int[] betterNums1;
        betterNums1 = makeMaxChange(nums1, nums2);
        return absoluteSumDiff(betterNums1, nums2);
    }
}

public class WeeklyContest235 {
    public static void main(String[] args) {
        SolutionWC235 solution = new SolutionWC235();
        int[] inputN1, inputN2;
        int resultMASD;

        // Example 1
        inputN1 = new int[]{1, 7, 5};
        inputN2 = new int[]{2, 3, 5};
        resultMASD = solution.minAbsoluteSumDiff(inputN1, inputN2);
        System.out.println("3 == " + resultMASD);

        // Example 2
        inputN1 = new int[]{2, 4, 6, 8, 10};
        inputN2 = new int[]{2, 4, 6, 8, 10};
        resultMASD = solution.minAbsoluteSumDiff(inputN1, inputN2);
        System.out.println("0 == " + resultMASD);

        // Example 3
        inputN1 = new int[]{1, 10, 4, 4, 2, 7};
        inputN2 = new int[]{9, 3, 5, 1, 7, 4};
        resultMASD = solution.minAbsoluteSumDiff(inputN1, inputN2);
        System.out.println("20 == " + resultMASD);

        //////////////////////////////////////////
        int[][] inputLogs;
        int inputK;
        int[] result;

        // Example 1
        inputLogs = new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        inputK = 5;
        result = solution.findingUsersActiveMinutes(inputLogs, inputK);
        System.out.println("[0,2,0,0,0] == " + Arrays.toString(result));

        // Example 2
        inputLogs = new int[][]{{1, 1}, {2, 2}, {2, 3}};
        inputK = 4;
        result = solution.findingUsersActiveMinutes(inputLogs, inputK);
        System.out.println("[1,1,0,0] == " + Arrays.toString(result));
    }
}
