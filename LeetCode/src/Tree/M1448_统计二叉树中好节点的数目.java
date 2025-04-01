package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2023/08/25，2025/04/01
 * @file M1448_统计二叉树中好节点的数目.java
 * <p>
 * 思路
 * 1. 向下dfs
 * 2. bfs
 */
public class M1448_统计二叉树中好节点的数目 {
    private int ans;

    public int goodNodes1_0(TreeNode root) {
        dfs1_0(root, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs1_0(TreeNode tn, int mx) {
        if (tn == null) {
            return;
        }
        if (tn.val >= mx) {
            mx = tn.val;
            ans++;
        }
        dfs1_0(tn.left, mx);
        dfs1_0(tn.right, mx);
    }

    public int goodNodes1_1(TreeNode root) {
        return dfs1_1(root, Integer.MIN_VALUE);
    }

    private int dfs1_1(TreeNode tn, int mx) {
        if (tn == null) {
            return 0;
        }

        return dfs1_1(tn.left, Math.max(mx, tn.val)) + dfs1_1(tn.right, Math.max(mx, tn.val)) + (tn.val >= mx ? 1 : 0);
    }

    public int goodNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> qNode = new ArrayDeque<>();
        Deque<Integer> qVal = new ArrayDeque<>();
        qNode.offer(root);
        qVal.offer(root.val);
        int ans = 0;
        while (!qNode.isEmpty()) {
            TreeNode p = qNode.poll(), l = p.left, r = p.right;
            int val = qVal.poll();
            if (p.val >= val) {
                ans++;
            }
            if (l != null) {
                qNode.offer(l);
                qVal.offer(Math.max(val, l.val));
            }
            if (r != null) {
                qNode.offer(r);
                qVal.offer(Math.max(val, r.val));
            }
        }

        return ans;
    }
}
