package dayChall202101;

class SolutionDay015 {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        int maxInt = 1;
        for (int i=1; 2*i<=n; i++) {
            nums[2 * i] = nums[i];
            if (2*i+1<=n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                maxInt = Math.max(maxInt, nums[2 * i + 1]);
            }
        }
        return maxInt;
    }
}
public class Day015_2021 {
    public static void main(String[] args) {
        SolutionDay015 solution = new SolutionDay015();
        for (int i = 0; i<=100; i++) {
            System.out.print(solution.getMaximumGenerated(i)+" ");
        }
        System.out.print("");
    }
}
