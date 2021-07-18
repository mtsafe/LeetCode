package dayChall202107;

import java.util.Arrays;

class SolutionDay717 {
    public int[] threeEqualParts(int[] arr) {
        int[] err = new int[]{-1, -1};
        if (arr == null) return err;
        int cnt = 0;
        for (int i : arr) {
            if (i == 1) cnt++;
        }
        if (cnt == 0 && arr.length >= 3) return new int[]{0, 2};
        if (cnt < 1 || cnt % 3 != 0) return err;
        cnt /= 3;
        int ii = 0, jj = 2, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (++sum == cnt) ii = i;
                else if (sum == 2 * cnt) jj = i + 1;
            }
        }
        for (int i = arr.length - 1; arr[i] == 0; i--)
            if (arr[++ii] != 0 || arr[jj++] != 0) return err;
        sum = 0;
        int tmp;
        for (int i = 0; sum < cnt; i++) {
            tmp = arr[arr.length-1-i];
            if (arr[ii-i]!=tmp || arr[jj-1-i]!=tmp) return err;
            if (tmp==1) sum++;
        }
        return new int[]{ii,jj};
    }
}

public class Day717_2021 {
    public static void main(String[] args) {
        SolutionDay717 solution = new SolutionDay717();
        int[] input;
        int[] result;

        // Example 1
        input = new int[]{1, 0, 1, 0, 1};
        result = solution.threeEqualParts(input);
        System.out.println("[0,3]" + Arrays.toString(result));

        // Example 2
        input = new int[]{1, 1, 0, 1, 1};
        result = solution.threeEqualParts(input);
        System.out.println("[-1,-1]" + Arrays.toString(result));

        // Example 3
        input = new int[]{1, 1, 0, 0, 1};
        result = solution.threeEqualParts(input);
        System.out.println("[0,2]" + Arrays.toString(result));
    }
}
