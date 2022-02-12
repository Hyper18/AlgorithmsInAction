package TwoPointer;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/12
 * <p>
 * 思路
 * 1. 合并后排序 -- 时间复杂度：O((m+n)log(m+n))
 * 2. 利用nums1后半部分空间，逆向双指针 -- 时间复杂度：O(m+n)
 */
public class Q88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        for (int i = m; i < len; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int idx = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                nums1[idx--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            } else {
                nums1[idx--] = p1 >= 0 ? nums1[p1--] : nums2[p2--];
            }
        }
    }
}
