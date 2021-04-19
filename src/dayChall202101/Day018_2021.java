package dayChall202101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SolutionDay018 {
    public int maxOperations(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i: nums)
            arr.add(i);
        Collections.sort(arr);
        int result = 0;
        int start = 0;
        int stop = nums.length - 1;
        while (start < stop) {
            if (arr.get(start) + arr.get(stop) == k) {
            System.out.println(arr.get(start)+" + "+arr.get(stop)+" == "+k);
                result++; start++; stop--;
            } else if (arr.get(start) < k - arr.get(stop))
                start++;
            else
                stop--;
        }
        return result;
    }
}

public class Day018_2021 {
    public static void main(String[] args) {
        SolutionDay018 solution = new SolutionDay018();
        int result;
        result = solution.maxOperations(new int[]
                {1,2,3,4}, 5);
        System.out.println("2 == "+result);
        result = solution.maxOperations(new int[]
                {3,1,3,4,3}, 6);
        System.out.println("1 == "+result);
        result = solution.maxOperations(new int[]
                {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2);
        System.out.println("2 == "+result);
    }
}
