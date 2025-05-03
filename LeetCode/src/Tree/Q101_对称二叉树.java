package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hyper
 * @date 2025/04/15，2025/05/03
 * @file Q101_对称二叉树.java
 * <p>
 * 思路
 * 1. dfs
 * 类似Q100
 * 2. bfs
 */
public class Q101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return true;
        }
        if (!check(root.left, root.right, q)) {
            return false;
        }
        while (!q.isEmpty()) {
            TreeNode sp = q.poll(), sq = q.poll();
            if (!check(sp.left, sq.right, q) || !check(sp.right, sq.left, q)) {
                return false;
            }
        }

        return true;
    }

    private boolean check(TreeNode p, TreeNode q, Deque<TreeNode> dq) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        dq.offer(p);
        dq.offer(q);

        return true;
    }
}
