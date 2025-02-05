package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hyper
 * @date 2024/02/26
 * @file M938_二叉搜索树的范围和.java
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 * <p>
 * 注意bfs时如使用ArrayDeque需额外考虑子树为null的情况
 */
public class M938_二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
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
