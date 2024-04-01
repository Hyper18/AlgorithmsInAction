package Array;

/**
 * @author Hyperspace
 * @date 2024/03/06
 * @file M2917_找出数组中的K_or值.java
 * <p>
 * 思路
 * 1. 位运算
 * 2. 优化
 * <p>
 * 注：中文题干很抽象
 */
public class M2917_找出数组中的K_or值 {
    final int N = 32;

    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            int cnt = 0;
            for (int x : nums) {
                cnt += check(x, i);
            }
            if (cnt >= k) {
                ans |= (1 << i);
            }
        }

        return ans;
    }

    private int check(int x, int i) {
        int t = (int) Math.pow(2, i);
        return (t & x) == t ? 1 : 0;
    }

    public int findKOr2(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            int cnt = 0;
            for (int x : nums) {
                cnt += x >> i & 1;
            }
            ans |= cnt >= k ? 1 << i : 0;
        }

        return ans;
    }
}
