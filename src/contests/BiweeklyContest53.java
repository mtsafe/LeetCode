package contests;

class SolutionWC53 {
    public int countGoodSubstrings(String s) {
        int result = 0;
        boolean isGood;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i + 1) != s.charAt(i + 2) &&
                    s.charAt(i) != s.charAt(i + 2))
                result++;
        }
        return result;
    }

    int adjustPairs(int[] nums){
        int[] tmp=new int[4];
        for (int i = 0; i< nums.length-2; i++,i++){
            if (nums[i]+nums[i+1]<nums[i+2]+nums[i+3]) {
                nums[i]=nums[i+2];
            }
        }
        return 0;
    }
    public int minPairSum(int[] nums) {
        return adjustPairs(nums);
    }
}

public class BiweeklyContest53 {
    public static void main(String[] args) {
        SolutionWC53 solution = new SolutionWC53();
        String inputS;
        int[] inputA;
        int resultI;

        // Example 1
        inputA = new int[]{3,5,2,3};
        resultI = solution.minPairSum(inputA);
        System.out.println("7 == " + resultI);

        // Example 2
        inputA = new int[]{3,5,4,2,4,6};
        resultI = solution.minPairSum(inputA);
        System.out.println("8 == " + resultI);

        //////////////////////////////////
        // Example 1
        inputS = "xyzzaz";
        resultI = solution.countGoodSubstrings(inputS);
        System.out.println("1 == " + resultI);

        // Example 2
        inputS = "aababcabc";
        resultI = solution.countGoodSubstrings(inputS);
        System.out.println("4 == " + resultI);
    }
}
