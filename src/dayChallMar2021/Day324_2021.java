package dayChallMar2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class SolutionDay324 {
    public int[] advantageCount(int[] A, int[] B) {
        HashMap<Integer, List<Integer>> hashB = new HashMap<>();
        List<Integer> tmpList;
        for (int i = 0; i < B.length; i ++) {
            if (hashB.containsKey(B[i])) {
                hashB.get(B[i]).add(i);
            } else {
                tmpList = new ArrayList<>();
                tmpList.add(i);
                hashB.put(B[i], tmpList);
            }
        }
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i<A.length; i++) {
            listA.add(A[i]);
            listB.add(B[i]);
        }
        listA.sort(Integer::compareTo);
        listB.sort(Integer::compareTo);
        for (int i = 0; i<A.length; i++) {
            
        }

        return null;
    }
}

public class Day324_2021 {
    public static void main(String[] args) {
        SolutionDay324 solution = new SolutionDay324();
        int[] inputA;
        int[] inputB;
        int[] result;

        // Example 1
        inputA = new int[]{2,7,11,15};
        inputB = new int[]{1,10,4,11};
        result = solution.advantageCount(inputA, inputB);
        System.out.println("[2,11,7,15] == "+ Arrays.toString(result));

        // Example2
        inputA = new int[]{12,24,8,32};
        inputB = new int[]{13,25,32,11};
        result = solution.advantageCount(inputA, inputB);
        System.out.println("[24,32,8,12] == "+ Arrays.toString(result));
    }
}
