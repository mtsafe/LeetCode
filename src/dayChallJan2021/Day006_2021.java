package dayChallJan2021;

// Problem Constraints:
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
// 1 <= k <= 1000
// arr[i] < arr[j] for 1 <= i < j <= arr.length
public class Day006_2021 {

    // O(n+m)
    private int lazyBruteForceFindKthPositive(int[] arr, int k) {
        int cnt = 0;
        int i = 0;
        int num = 1;
        for (; num < arr[arr.length-1]; num++) {
            if (arr[i] == num)
                i++;
            else if (++cnt == k)
                return num;
        }
        while(cnt++ != k)
            num++;
        return num;
    }

    public int findKthPositive(int[] arr, int k) {
        return lazyBruteForceFindKthPositive(arr, k);
    }
}