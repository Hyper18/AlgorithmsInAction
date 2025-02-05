package Array;

/**
 * @author Hyper
 * @date 2024/05/18
 * @file M2644_找出可整除性得分最大的整数.java
 * <p>
 * 思路
 * 朴素
 */
public class M2644_找出可整除性得分最大的整数 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int mx = 0, ans = divisors[0];
        for (int d : divisors) {
            int t = 0;
            for (int n : nums) {
                if (n % d == 0) {
                    t++;
                }
            }
            if (t > mx) {
                mx = t;
                ans = d;
            } else if (t == mx && ans > d) {
                ans = d;
            }
        }

        return ans;
    }
}
