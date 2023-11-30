package Greedy;

/**
 * @author Hyperspace
 * @date 2023/11/11
 * @file M765_情侣牵手.java
 * <p>
 * 思路
 * 贪心
 */
public class M765_情侣牵手 {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[row[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i += 2) {
            int a = row[i], b = a ^ 1;
            if (row[i + 1] != b) {
                int src = i + 1, tar = cache[b];
                cache[row[tar]] = src;
                cache[row[src]] = tar;
                swap(row, src, tar);
                ans++;
            }
        }

        return ans;
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
