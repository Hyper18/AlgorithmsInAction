package Tree;

import java.util.*;

/**
 * @author Hyper
 * @date 2025/04/15，2025/05/03
 * @file Q199_二叉树的右视图.java
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 */
public class Q199_二叉树的右视图 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode cur, int d) {
        if (cur == null) {
            return;
        }
        if (res.size() == d) {
            res.add(cur.val);
        }
        dfs(cur.right, d + 1);
        dfs(cur.left, d + 1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode p = q.poll();
                if (i == n - 1) {
                    res.add(p.val);
                }
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
        }

        return res;
    }
}
