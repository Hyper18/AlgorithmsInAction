package DP.TreeDP;

/**
 * @author Hyperspace
 * @date 2022/02/23
 * <p>
 * 树形dp -- O(n^2)
 * 1. 确定dp数组（dp table）以及下标的含义
 * dp[i]： 1到i为节点组成的二叉搜索树的个数为dp[i]
 * 2. 确定递推公式
 * dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
 * j相当于是头结点的元素
 * 递推公式：dp[i] += dp[j - 1] * dp[i - j]
 * 3. dp数组初始化
 * 4. 确定遍历顺序
 * 遍历节点数，i里面每一个数作为头结点的状态，用j来遍历
 * 5. 举例推导dp数组
 */
public class Q96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
