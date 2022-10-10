package DP;

/**
 * @author Hyperspace
 * @date 2022/10/10
 * <p>
 * 思路
 * 状态机DP
 * 可以考虑对于指定位，只存在交换与不交换两种情况
 * 1. 状态表示
 * 集合
 * f[i][0]表示到第i位时使数组满足nums1和nums2严格递增，且第i位不进行交换操作的最小操作次数
 * f[i][1]表示到第i位时使数组满足nums1和nums2严格递增，且第i位进行了交换操作的最小操作次数
 * 属性：min
 * 2. 状态计算
 * 分类讨论：
 * 1）当前nums1和nums2序列的前后两数符合严格递增
 * f[i][0] = f[i - 1][0]
 * f[i][1] = f[i - 1][1] + 1
 * 2）当前nums1和nums2序列的前后两数不符合严格递增
 * f[i][0] = min(f[i][0], f[i - 1][1])
 * f[i][1] = min(f[i][1], f[i - 1][0] + 1)
 */
public class M801_使序列递增的最小交换次数 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i][1] = n;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1] + 1;
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }

        return Math.min(f[n - 1][0], f[n - 1][1]);
    }

    /**
     * 状压
     *
     * @param nums1
     * @param nums2
     * @return min
     */
    public int minSwap2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int cnt1 = 0, cnt2 = 1;
        for (int i = 1; i < n; i++) {
            int ns = n, s = n;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                ns = cnt1;
                s = cnt2 + 1;
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                ns = Math.min(ns, cnt2);
                s = Math.min(s, cnt1 + 1);
            }
            cnt1 = ns;
            cnt2 = s;
        }

        return cnt1 < cnt2 ? cnt1 : cnt2;
    }
}
