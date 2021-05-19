package dayChall202105;

class SolutionDay519 {
    public int minMoves2(int[] nums) {
        if (nums==null) return 0;
        long sum =0, avg;
        for (int num: nums) {
            sum+=num;
        }
        avg = sum / nums.length;
        if (avg < Integer.MIN_VALUE || avg > Integer.MAX_VALUE)
            System.err.println("average is out of bounds");
        sum =0;
        for (int num: nums) {
            sum+=Math.abs(avg - num);
        }
        return (int) sum;
    }
}

public class Day519_2021 {
    public static void main(String[] args) {
        SolutionDay519 solution = new SolutionDay519();
        int[] inputN;
        int result;

        // Example 1
        inputN = new int[]{1,2,3};
        result = solution.minMoves2(inputN);
        System.out.println("2 == "+result);

        // Example 2
        inputN = new int[]{1,10,2,9};
        result = solution.minMoves2(inputN);
        System.out.println("16 == "+result);

        // Example 3
        inputN = new int[]{1,0,0,8,6};
        result = solution.minMoves2(inputN);
        System.out.println("14 == "+result);
    }
}
