package Array;

/**
 * @author Hyper
 * @date 2024/10/23
 * @file M3185_构成整天的下标对数目II.java
 * <p>
 * 思路
 * 1. 模拟 O(n^2) TLE
 * 2. 优化 O(n)
 */
public class M3185_构成整天的下标对数目II {
    public long countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        long ans = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public long countCompleteDayPairs2(int[] hours) {
        int[] cnt = new int[24];
        long ans = 0;
        for (int h : hours) {
            ans += cnt[(24 - h % 24) % 24];
            cnt[h % 24]++;
        }

        return ans;
    }
}
