package Array;

/**
 * @author Hyperspace
 * @date 2023/09/01
 * @file M2240_买钢笔和铅笔的方案数.java
 * <p>
 * 思路
 * 模拟
 */
public class M2240_买钢笔和铅笔的方案数 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; i <= total / cost1; i++) {
            int j = (total - i * cost1) / cost2 + 1;
            ans += j;
        }

        return ans;
    }
}
