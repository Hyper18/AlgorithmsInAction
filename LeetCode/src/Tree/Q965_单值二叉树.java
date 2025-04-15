package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hyper
 * @date 2025/04/15
 * @file Q965_单值二叉树.java
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 */
public class Q965_单值二叉树 {
    private boolean ans = true;
    private int val;

    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (cur.val != val) {
            ans = false;
        }
        dfs(cur.right);
    }

    public boolean isUnivalTree2(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int val = root.val;
        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            if (p.val != val) {
                return false;
            }
            if (p.left != null) {
                q.offer(p.left);
            }
            if (p.right != null) {
                q.offer(p.right);
            }
        }

        return true;
    }
}
