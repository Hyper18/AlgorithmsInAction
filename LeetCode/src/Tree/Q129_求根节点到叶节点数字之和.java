package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2025/04/01
 * @file Q129_求根节点到叶节点数字之和.java
 * <p>
 * 思路
 * 1. 向下dfs
 * 2. bfs
 */
public class Q129_求根节点到叶节点数字之和 {
    private int ans = 0;

    public int sumNumbers1_0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, "");

        return ans;
    }

    private void dfs(TreeNode tn, String s) {
        if (tn.left == null && tn.right == null) {
            ans += Integer.parseInt(s + tn.val);
            return;
        }
        s += tn.val;
        if (tn.left != null) {
            dfs(tn.left, s);
        }
        if (tn.right != null) {
            dfs(tn.right, s);
        }
    }

    public int sumNumbers1_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);

        return ans;
    }

    private void dfs(TreeNode tn, int sum) {
        if (tn.left == null && tn.right == null) {
            ans += sum * 10 + tn.val;
            return;
        }
        sum = sum * 10 + tn.val;
        if (tn.left != null) {
            dfs(tn.left, sum);
        }
        if (tn.right != null) {
            dfs(tn.right, sum);
        }
    }

    public int sumNumbers1_2(TreeNode root) {
        return dfs1_2(root, 0);
    }

    private int dfs1_2(TreeNode tn, int sum) {
        if (tn == null) {
            return 0;
        }
        sum = sum * 10 + tn.val;
        if (tn.left == tn.right) {
            return sum;
        }

        return dfs1_2(tn.left, sum) + dfs1_2(tn.right, sum);
    }

    public int sumNumbers2(TreeNode root) {
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
            if (l == r) {
                ans += val;
                continue;
            }
            if (l != null) {
                qNode.offer(l);
                qVal.offer(val * 10 + l.val);
            }
            if (r != null) {
                qNode.offer(r);
                qVal.offer(val * 10 + r.val);
            }
        }

        return ans;
    }
}
