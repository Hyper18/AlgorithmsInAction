package Array;

/**
 * @author Hyperspace
 * @date 2023/09/20
 * @file M_LCP06_拿硬币.java
 * <p>
 * 思路
 * 模拟
 */
public class M_LCP06_拿硬币 {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int c : coins) {
            ans += Math.ceil((double) c / 2);
        }

        return ans;
    }
}
