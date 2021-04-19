package dayChall202103;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SolutionDay323 {
    static class Stacker {
        static long[] arr;
        static int maxStacker;

        static void extendStacker(int max) {
            if (maxStacker >= max) return;
            long[] tmp = new long[max];
            System.arraycopy(arr, 0, tmp, 0, maxStacker);
            maxStacker = max;
            arr = tmp;
        }

        static long level(int n) {
            if (n == 0) return 0;
            if (arr[n] != 0) return arr[n];
            for (int i = 1; i <= n; i++) {
                arr[n] += i;
            }
            arr[n] += level(n - 1);
            return arr[n];
        }
    }

    private HashMap<Integer, Integer> makeHashMap(int[] arr, int target) {
        if (arr == null) return null;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : arr) {
            if (i > target) continue;
            if (hash.containsKey(i))
                hash.replace(i, hash.get(i) + 1);
            else
                hash.put(i, 1);
        }
        return hash;
    }

    private long combine(int a, int b, int c) {
        long result = a;
        result *= b;
        result *= c;
        return result;
    }

    private long combine1And2(int a, int b2) {
        long result = 0;
        for (int i = 1; i < b2; i++) {
            result += i;
        }
        result *= a;
        return result;
    }

    private long permute3(int a) {
        return Stacker.level(a);
    }

    public int threeSumMulti(int[] arr, int target) {
        if (arr == null) return 0;
        if (arr.length > Stacker.maxStacker)
            Stacker.extendStacker(arr.length);
        long tupleCnt = 0;
        HashMap<Integer, Integer> hash = makeHashMap(arr, target);
        List<Integer> list = new ArrayList<>(hash.keySet());
        list.sort(Integer::compareTo);
        int k, iTh, jTh, kTh;
        for (int i = 0; i < list.size() - 2; i++) {
            iTh = list.get(i);
            // case: suppose j == i
            // case: suppose k == j == i
                // permute3(hash.get(iTh));
            for (int j = i + 1; j < list.size() - 1; j++) {
                jTh = list.get(j);
                kTh = target - iTh - jTh;
                if (kTh < jTh) {
                    break;
                } else if (kTh == jTh) {
                    tupleCnt += combine1And2(hash.get(iTh), hash.get(jTh));
                } else {
                    tupleCnt += combine(hash.get(iTh), hash.get(jTh), hash.get(kTh));
                }
            }
        }
        return 0;
    }
}

public class Day323_2021 {
    public static void main(String[] args) {
        SolutionDay323 solution = new SolutionDay323();
        int[] inputA;
        int inputT;
        int result;

        // Example 1
        inputA = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        inputT = 8;
        result = solution.threeSumMulti(inputA, inputT);
        System.out.println("20 == " + result);

        // Example 2
        inputA = new int[]{1, 1, 2, 2, 2, 2};
        inputT = 12;
        result = solution.threeSumMulti(inputA, inputT);
        System.out.println("12 == " + result);
    }
}
