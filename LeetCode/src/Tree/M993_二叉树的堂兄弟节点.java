package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2024/02/08
 * @file M993_二叉树的堂兄弟节点.java
 * <p>
 * 思路
 * bfs
 */
public class M993_二叉树的堂兄弟节点 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode fa = root;
            boolean hasX = false, hasY = false;
            Queue<TreeNode> cur = new ArrayDeque<>();
            for (TreeNode tr : q) {
                if (tr.left != null) {
                    if (tr.left.val == x) {
                        fa = tr;
                        hasX = !hasX;
                    }
                    if (tr.left.val == y) {
                        fa = tr;
                        hasY = !hasY;
                    }
                    cur.offer(tr.left);
                }
                if (tr.right != null) {
                    if (fa != tr && tr.right.val == x) {
                        hasX = !hasX;
                    }
                    if (fa != tr && tr.right.val == y) {
                        hasY = !hasY;
                    }
                    cur.offer(tr.right);
                }
            }
            if (hasX && hasY) {
                return true;
            }
            q = cur;
        }

        return false;
    }
}
