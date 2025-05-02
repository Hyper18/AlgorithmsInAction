package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q513_找树左下角的值.java
 * <p>
 * 思路
 * 1. bfs
 * 2. bfs
 * 入队顺序：右 -> 左
 * 则最后一个出队的为左孩子
 */
public class Q513_找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = -1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode p = q.poll();
                if (i == 0) {
                    ans = p.val;
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

    public int findBottomLeftValue2(TreeNode root) {
        TreeNode p = root;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            p = q.poll();
            if (p.right != null) {
                q.offer(p.right);
            }
            if (p.left != null) {
                q.offer(p.left);
            }
        }

        return p.val;
    }
}
