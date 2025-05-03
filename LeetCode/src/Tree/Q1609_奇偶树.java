package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q1609_奇偶树.java
 * <p>
 * 思路
 * bfs
 * 处理当层比处理子节点好写，不需要单独处理root
 * <p>
 * 题目已保证不会输入空节点
 */
public class Q1609_奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int d = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            int pre = d % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (n-- > 0) {
                TreeNode p = q.poll();
                if (d % 2 == p.val % 2 || (d % 2 == 0 && p.val <= pre) || (d % 2 == 1 && p.val >= pre)) {
                    return false;
                }
                pre = p.val;
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
            d++;
        }

        return true;
    }
}
