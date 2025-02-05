package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/12，2023/08/13
 * @file M88_合并两个有序数组.java
 */
public class M88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        if (len - m >= 0) {
            System.arraycopy(nums2, 0, nums1, m, len - m);
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, idx = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                nums1[idx--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            } else {
                nums1[idx--] = p1 >= 0 ? nums1[p1--] : nums2[p2--];
            }
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }
}
