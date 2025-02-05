package BinarySearch;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/19
 * <p>
 * 思路
 * 1. 先复制再排序 -- O((m+n)log(m+n))
 * 2. 归并 -- O(n)
 * 3. 不合并 二分 -- O(log (min(m,n)))
 */
public class Q4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];
        System.arraycopy(nums1, 0, arr, 0, m);
        System.arraycopy(nums2, 0, arr, m, n);
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) >> 1;
        if (arr.length % 2 == 1) {
            return arr[mid];
        } else {
            return (double) (arr[mid] + arr[mid + 1]) / 2;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p1 >= m) {
                arr[i] = nums2[p2++];
            } else if (p2 >= n) {
                arr[i] = nums1[p1++];
            } else {
                arr[i] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
            }
        }

        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) >> 1;
        if (arr.length % 2 == 1) {
            return arr[mid];
        } else {
            return (double) (arr[mid] + arr[mid + 1]) / 2;
        }
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (m + n + 1) / 2;
        int low = 0;
        int high = m;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            int mid2 = totalLeft - mid;
            if (nums1[mid - 1] > nums2[mid2]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        int i = low;
        int j = totalLeft - i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2D;
        }
    }
}
