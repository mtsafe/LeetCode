package dayChall202101;

import java.util.Arrays;

class SolutionDay010 {
    public int createSortedArray(int[] instructions) {
        int totalCost = 0;
        int[] arr = new int[instructions.length];
        int last = 0;
        for (int x : instructions) {
//            int prev = Arrays.binarySearch(arr, 0, last, x-1);
//            if (prev < 0)
//                prev = - (prev + 1);
//            System.out.print(prev+" ");

            int insertionPoint = Arrays.binarySearch(arr, 0, last, x);
            if (insertionPoint < 0)
                insertionPoint = -(insertionPoint + 1);
            else {
                while (insertionPoint - 1 >= 0 &&
                        arr[insertionPoint] == arr[insertionPoint - 1]) {
                    insertionPoint--;
                }
            }
            System.out.print(insertionPoint + " ");
            int lowerCost = insertionPoint;

            int next = Arrays.binarySearch(arr, 0, last, x + 1);
            if (next < 0)
                next = -(next + 1);
            else {
                while (next + 1 <= last &&
                        arr[next] == arr[next + 1]) {
                    next++;
                }
            }
            System.out.print(next + " ");
            int upperCost = last - next;

            totalCost += Math.min(lowerCost, upperCost);

            System.out.print("lower=" + lowerCost + " upper=" + upperCost + " total=" + totalCost + " ");

            if (last - insertionPoint >= 0)
                System.arraycopy(arr, insertionPoint, arr, insertionPoint + 1, last - insertionPoint);
            arr[insertionPoint] = x;
            System.out.println(Arrays.toString(arr));

            last++;
        }
        return totalCost;
    }
}

public class Day010_2021 {
    public static void main(String[] args) {
        SolutionDay010 solution = new SolutionDay010();
        int totalCost;
        totalCost = solution.createSortedArray(new int[]{50, 40, 30, 20, 10, 1});
        System.out.println(totalCost);
        totalCost = solution.createSortedArray(new int[]{1, 10, 20, 50, 40, 30});
        System.out.println(totalCost);
        totalCost = solution.createSortedArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(totalCost);
        totalCost = solution.createSortedArray(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3});
        System.out.println(totalCost);
        totalCost = solution.createSortedArray(new int[]{3, 3, 3, 1, 1, 2, 2, 2});
        System.out.println(totalCost);

        // example 1: Should print 1
        totalCost = solution.createSortedArray(new int[]{1, 5, 6, 2});
        System.out.println(totalCost);
        // example 2: Should print 3
        totalCost = solution.createSortedArray(new int[]{1, 2, 3, 6, 5, 4});
        System.out.println(totalCost);
        // example 3: Should print 4
        totalCost = solution.createSortedArray(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2});
        System.out.println(totalCost);
    }
}
