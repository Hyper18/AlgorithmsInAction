package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2022/04/22，2025/04/01，2025/05/03
 * 思路
 * 1. 向下dfs
 * 先走左子树
 * 若两子树均为空，则返回
 * 2. 向上dfs
 * 3. bfs
 */
public class Q111_二叉树的最小深度 {
    public int minDepth1_0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(ans, minDepth1_0(root.left));
        }
        if (root.right != null) {
            ans = Math.min(ans, minDepth1_0(root.right));
        }

        return ans + 1;
    }

    private int ans = Integer.MAX_VALUE;

    public int minDepth1_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode tn, int cnt) {
        if (tn == null || ++cnt > ans) {
            return;
        }
        if (tn.left == tn.right) {
            ans = cnt;
            return;
        }
        dfs(tn.left, cnt);
        dfs(tn.right, cnt);
    }

    public int minDepth2_0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth2_0(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth2_0(root.left) + 1;
        }

        return Math.min(minDepth2_0(root.left), minDepth2_0(root.right)) + 1;
    }

    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int n = q.size();
            while (n-- > 0) {
                TreeNode p = q.poll();
                if (p.left == null && p.right == null) {
                    return ans;
                }
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
        }

        return ans;
    }
}
