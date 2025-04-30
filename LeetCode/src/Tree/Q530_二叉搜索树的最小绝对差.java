package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/04/30
 * @file Q530_二叉搜索树的最小绝对差.java
 * <p>
 * 思路
 * 1. dfs+排序
 * 暴力做法，并没有利用到二叉搜索树的特性
 * 2. dfs优化
 * 核心：对二叉搜索树的中序遍历，记录 val 得到的是一个递增序列
 */
public class Q530_二叉搜索树的最小绝对差 {
    private List<Integer> li = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        Collections.sort(li);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < li.size(); i++) {
            ans = Math.min(ans, li.get(i) - li.get(i - 1));
        }

        return ans;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        li.add(cur.val);
        dfs(cur.right);
    }

    private int pre = -1, ans = Integer.MAX_VALUE;

    public int getMinimumDifference2(TreeNode root) {
        dfs2(root);
        return ans;
    }

    private void dfs2(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs2(cur.left);
        if (pre != -1) {
            ans = Math.min(ans, cur.val - pre);
        }
        pre = cur.val;
        dfs2(cur.right);
    }
}
