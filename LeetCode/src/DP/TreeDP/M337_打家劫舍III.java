package DP.TreeDP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2023/09/19
 * @file M337_打家劫舍III.java
 * <p>
 * 思路
 * 分类讨论：
 * 1) 选取根节点的情况
 * 当前节点能偷到的最大钱数 = 左孩子所有能偷到的钱数 + 右孩子所有能偷到的钱数 + 当前节点的钱数
 * res[0] 取当前结点
 * res[1] 不取当前结点
 * 2) 不选取根节点的情况
 * 当前节点能偷到的最大钱数 = 左孩子所有能偷到的钱数 + 右孩子所有能偷到的钱数
 * <p>
 * TLE的写法
 * 优化 - 记忆化搜索
 */
public class M337_打家劫舍III {
    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(sum, rob(root.left) + rob(root.right));
    }

    Map<TreeNode, Integer> mp = new HashMap<>();

    public int rob2(TreeNode root) {
        return dfs2(root);
    }

    private int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (mp.containsKey(root)) {
            return mp.get(root);
        }
        int sum = root.val;
        if (root.left != null) {
            sum += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null) {
            sum += rob2(root.right.left) + rob2(root.right.right);
        }
        int ans = Math.max(sum, rob2(root.left) + rob2(root.right));
        mp.put(root, ans);

        return ans;
    }

    public int rob3(TreeNode root) {
        int[] res = dfs3(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs3(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2], l = dfs3(root.left), r = dfs3(root.right);
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = l[0] + r[0] + root.val;

        return res;
    }
}
