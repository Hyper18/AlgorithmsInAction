package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2022/03/01，2025/03/30
 * <p>
 * 思路
 * 1. 向下dfs
 * 2. 向上dfs
 * 3. bfs
 */
public class Q104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int l = dfs(tn.left), r = dfs(tn.right);

        return Math.max(l, r) + 1;
    }

    private int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth2(root.left), r = maxDepth2(root.right);

        return Math.max(l, r) + 1;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                TreeNode p = q.poll();
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
                n--;
            }
            ans++;
        }

        return ans;
    }
}
