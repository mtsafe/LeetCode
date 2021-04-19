package dayChall202103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionDay324 {
    public int[] advantageCount(int[] A, int[] B) {
        if (A == null || B == null) return null;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i<A.length; i++) {
            listA.add(A[i]);
            listB.add(B[i]);
        }
        listA.sort(Integer::compareTo);
        List<Integer> listR = new ArrayList<>();
        int nextB;
        for (int j = 0; j<B.length; j++) {
            nextB = listB.get(j);
            for (int i = 0; i<listA.size(); i++) {
                if (listA.get(i) > nextB) {
                    listR.add(listA.remove(i));
                    break;
                }
            }
            if (listR.size() == j)
                listR.add(listA.remove(0));
        }
        int[] result = new int[listR.size()];
        for (int i = 0; i < listR.size(); i++)
            result[i] = listR.get(i);
        return result;
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
