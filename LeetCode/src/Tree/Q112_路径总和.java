package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2025/04/01，2025/05/03
 * @file Q112_路径总和.java
 * <p>
 * 思路
 * 1. 向下dfs
 * 2. bfs
 */
public class Q112_路径总和 {
    private boolean ans;
    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.targetSum = targetSum;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode cur, int sum) {
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null) {
            if (targetSum == sum + cur.val) {
                ans = true;
            }
            return;
        }
        sum += cur.val;
        dfs(cur.left, sum);
        dfs(cur.right, sum);
    }

    public boolean hasPathSum1_1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return hasPathSum1_1(root.left, targetSum) || hasPathSum1_1(root.right, targetSum);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> qNode = new ArrayDeque<>();
        Deque<Integer> qVal = new ArrayDeque<>();
        qNode.offer(root);
        qVal.offer(root.val);
        while (!qNode.isEmpty()) {
            TreeNode p = qNode.poll(), l = p.left, r = p.right;
            int val = qVal.poll();
            if (l == null && r == null) {
                if (val == targetSum) {
                    return true;
                }
                continue;
            }
            if (l != null) {
                qNode.offer(l);
                qVal.offer(val + l.val);
            }
            if (r != null) {
                qNode.offer(r);
                qVal.offer(val + r.val);
            }
        }

        return false;
    }
}
