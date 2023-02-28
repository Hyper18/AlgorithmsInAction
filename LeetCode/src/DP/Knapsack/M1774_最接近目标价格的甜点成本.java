package DP.Knapsack;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/12/04
 * @file M1774_最接近目标价格的甜点成本.java
 */
public class M1774_最接近目标价格的甜点成本 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 获取基料最小值，若已经大于target则无需添加配料
        int baseMin = Arrays.stream(baseCosts).min().getAsInt();
        if (baseMin >= target) {
            return baseMin;
        }

        // 设置背包容积为target
        boolean[] f = new boolean[target + 1];

        // 利用对称思想，维护target右侧的最小值
        int ans = target * 2 - baseMin;
        // init f
        for (int b : baseCosts) {
            if (b <= target) {
                f[b] = true;
            } else {
                ans = Math.min(ans, b);
            }
        }

        // 添加辅料
        for (int t : toppingCosts) {
            // 遍历物品，题干已指明每种基料最多可加两种辅料
            for (int i = 0; i < 2; i++) {
                // 遍历背包
                for (int v = target; v > 0; v--) {
                    // 在target右侧，更新ans
                    if (f[v] && v + t > target) {
                        ans = Math.min(ans, v + t);
                    }
                    // 找去掉当前这份配料，上一份合法方案的位置
                    if (v - t > 0) {
                        f[v] = f[v] | f[v - t];
                    }
                }
            }
        }

        // 从target左手开始，向左遍历直到左侧和ans对称的位置
        for (int i = 0; i <= ans - target; i++) {
            if (f[target - i]) {
                return target - i;
            }
        }
        // 左侧没有，返回右侧的合法值
        return ans;
    }
}
