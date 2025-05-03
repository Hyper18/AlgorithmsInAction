package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q1302_层数最深叶子节点的和.java
 * <p>
 * 思路
 * bfs
 */
public class Q1302_层数最深叶子节点的和 {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            ans = 0;
            while (n-- > 0) {
                TreeNode p = q.poll();
                ans += p.val;
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
