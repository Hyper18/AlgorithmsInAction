package Tree;

/**
 * @author Hyper
 * @date 2024/02/28
 * @file M2673_使二叉树所有路径值相等的最小代价.java
 * <p>
 * 思路
 * 自下而上贪心
 */
public class M2673_使二叉树所有路径值相等的最小代价 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i + 1]);
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }

        return ans;
    }
}
