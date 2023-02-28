package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/12/07
 * @file M1775_通过最少操作次数使数组的和相等.java
 * <p>
 * 思路
 * 哈希，贪心
 */
public class M1775_通过最少操作次数使数组的和相等 {
    final int N = 6;

    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
        int diff = sum1 - sum2;
        if (diff == 0) {
            return 0;
        }
        if (diff < 0) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
            diff = -diff;
        }

        int n1 = nums1.length, n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (n1 > n2 * N) {
            return -1;
        }

        int[] cnt = new int[N];
        for (int n : nums1) {
            cnt[n - 1]++;
        }
        for (int n : nums2) {
            cnt[6 - n]++;
        }
        int ans = 0;
        for (int i = N - 1; i > 0 && diff > 0; i--) {
            int cur = Math.min(cnt[i], (diff + i - 1) / i);
            ans += cur;
            diff -= cur * i;
        }

        return diff > 0 ? -1 : ans;
    }

//    public int minOperations2(int[] nums1, int[] nums2) {
//        int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
//        int diff = sum1 - sum2;
//        if (diff == 0) {
//            return 0;
//        }
//        if (diff < 0) {
//            int[] t = nums1;
//            nums1 = nums2;
//            nums2 = t;
//            diff = -diff;
//        }
//
//        int n1 = nums1.length, n2 = nums2.length;
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        if (n1 > n2 * N) {
//            return -1;
//        }
//        int ans = 0;
//        for (int i = n1 - 1, j = 0; i > 0 && j < n2 && diff > 0; ans++) {
//            int c1 = nums1[i] - 1, c2 = 6 - nums2[j];
//            if (c1 >= c2) {
//                diff -= c1;
//                nums1[i] = 1;
//                i--;
//            } else {
//                diff -= c2;
//                nums2[j] = 6;
//                j++;
//            }
//        }
//
//        return diff > 0 ? -1 : ans;
//    }
}
