package contests;

import java.util.Arrays;

class SolutionWC224 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int maxLenCnt = 0;
        int tmpLen;
        for (int[] rectangle: rectangles) {
            tmpLen = Math.min(rectangle[0], rectangle[1]);
            if (tmpLen > maxLen) {
                maxLenCnt = 1;
                maxLen = tmpLen;
            } else if (tmpLen == maxLen) {
                maxLenCnt++;
            }
        }
        return maxLenCnt;
    }
    public int tupleSameProduct(int[] nums) {
        if (nums.length < 4) return 0;
        Arrays.sort(nums);
        int comboCnt = 0;
        int aStop = nums.length - 3;
        int bStop = nums.length - 2;
        int cStop = nums.length - 1;
        int dStop = nums.length;
        for (int a = 0; a < aStop; a++) {
            if (nums[a] * nums[dStop-1] < nums[a+1] * nums[a+2])
                continue;
            for (int b = a+1; b < bStop; b++) {
                for (int c = b+1; c < cStop; c++) {
                    for (int d = c+1; d < dStop; d++) {
//                        System.out.println(nums[a]+" "+nums[b]+" "+nums[c]+" "+nums[d]);
                        if (nums[d] > nums[b] * nums[c] / nums[a])
                            break;
                        if (nums[a] * nums[b] == nums[c] * nums[d])
                            comboCnt++;
                        if (nums[a] * nums[c] == nums[b] * nums[d])
                            comboCnt++;
                        if (nums[a] * nums[d] == nums[b] * nums[c])
                            comboCnt++;
                    }
                }
            }
        }
        return comboCnt * 8;
    }
}

public class WeeklyContest224 {
    public static void main(String[] args) {
        SolutionWC224 solution = new SolutionWC224();
        int result;
        result = solution.countGoodRectangles(new int[][]
                {{5,8},{3,9},{5,12},{16,5}});
        System.out.println(result);
        result = solution.countGoodRectangles(new int[][]
                {{2,3},{3,7},{4,3},{3,7}});
        System.out.println(result);

        result = solution.tupleSameProduct(new int[] {});
        System.out.println(result);
        result = solution.tupleSameProduct(new int[] {2,3,4,6});
        System.out.println(result);
        result = solution.tupleSameProduct(new int[] {1,2,4,5,10});
        System.out.println(result);
        result = solution.tupleSameProduct(new int[] {2,3,4,6,8,12});
        System.out.println(result);
        result = solution.tupleSameProduct(new int[] {2,3,5,7});
        System.out.println(result);
        result = solution.tupleSameProduct(new int[] {20,10,6,24,15,5,4,30});
        System.out.println(result);
    }
}
