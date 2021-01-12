package dailyChallenges;

import java.util.Arrays;

class SolutionDay011 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < m && i2 < n) {
            if (nums1[i1] < nums2[i2])
                arr[j++] = nums1[i1++];
            else
                arr[j++] = nums2[i2++];
        }
        while (i1 < m)
            arr[j++] = nums1[i1++];
        while (i2 < n)
            arr[j++] = nums2[i2++];
        System.arraycopy(arr, 0, nums1, 0, m+n);
    }
}

public class Day011_2021 {
    public static void main(String[] args) {
        SolutionDay011 solution = new SolutionDay011();
        int[] nums1, nums2;
        nums1 = new int[] {1,2,3,0,0,0};
        nums2 = new int[] {2,5,6};
        solution.merge(nums1,3, nums2,3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {1};
        nums2 = new int[] {};
        solution.merge(nums1,1, nums2,0);
        System.out.println(Arrays.toString(nums1));
    }
}
