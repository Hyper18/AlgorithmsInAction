package Array;

/**
 * @author Hyperspace
 * @date 2024/06/20
 * @file M2748_美丽下标对的数目.java
 * <p>
 * 思路
 * 1. 模拟 O(n^2)
 * 2. 边遍历边统计最高位的出现次数 O(n)
 */
public class M2748_美丽下标对的数目 {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(getFirst(nums[i]), nums[j] % 10) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private int getFirst(int x) {
        while (x / 10 > 0) {
            x /= 10;
        }

        return x;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int countBeautifulPairs2(int[] nums) {
        int ans = 0;
        int[] cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++) {
                if (cnt[y] > 0 && gcd(y, x % 10) == 1) {
                    ans += cnt[y];
                }
            }
            while (x >= 10) {
                x /= 10;
            }
            cnt[x]++;
        }

        return ans;
    }
}
