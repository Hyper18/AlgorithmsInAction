package Array;

/**
 * @author Hyperspace
 * @date 2023/09/15
 * @file M_LCP50_宝石补给.java
 * <p>
 * 思路
 * 模拟，向下取整
 * 最后一次遍历最大值和最小值
 */
public class M_LCP50_宝石补给 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            int t = gem[op[0]] / 2;
            gem[op[0]] -= t;
            gem[op[1]] += t;
        }
        int mn = 1000, mx = 0;
        for (int g : gem) {
            mn = Math.min(mn, g);
            mx = Math.max(mx, g);
        }

        return mx - mn;
    }
}
