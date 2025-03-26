package Greedy;

/**
 * @author Hyper
 * @date 2025/03/26
 * @file M2829_k_avoiding数组的最小总和.java
 * <p>
 * 思路
 * 贪心
 */
public class M2829_k_avoiding数组的最小总和 {
    public int minimumSum(int n, int k) {
        int ans = 0;
        for (int i = 1; i <= Math.min(k / 2, n); i++) {
            ans += i;
        }
        for (int i = 0; i < n - k / 2; i++) {
            ans += k + i;
        }

        return ans;
    }
}
