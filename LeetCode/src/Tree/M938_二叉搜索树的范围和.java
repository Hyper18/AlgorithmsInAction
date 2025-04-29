package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hyper
 * @date 2024/02/26，2025/04/29
 * @file M938_二叉搜索树的范围和.java
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 * <p>
 * 注意bfs时如使用ArrayDeque需额外考虑子树为null的情况
 */
public class M938_二叉搜索树的范围和 {
    public int rangeSumBST1_0(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST1_0(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST1_0(root.left, low, high);
        }

        return root.val + rangeSumBST1_0(root.left, low, high) + rangeSumBST1_0(root.right, low, high);
    }

    private int ans;

    public int rangeSumBST1_1(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    private void dfs(TreeNode cur, int l, int r) {
        if (cur == null) {
            return;
        }
        if (l <= cur.val && cur.val <= r) {
            ans += cur.val;
        }
        dfs(cur.left, l, r);
        dfs(cur.right, l, r);
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        int ans = 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            if (p == null) {
                continue;
            }
            if (p.val < low) {
                q.offer(p.right);
            } else if (p.val > high) {
                q.offer(p.left);
            } else {
                ans += p.val;
                q.offer(p.left);
                q.offer(p.right);
            }
        }

        return ans;
    }
}
