package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/02/08，2025/05/03
 * @file M993_二叉树的堂兄弟节点.java
 * <p>
 * 思路
 * bfs
 */
public class M993_二叉树的堂兄弟节点 {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode fa = root;
            boolean hasX = false, hasY = false;
            List<TreeNode> t = new ArrayList<>();
            for (TreeNode p : q) {
                if (p.left != null) {
                    t.add(p.left);
                    if (p.left.val == x) {
                        fa = p;
                        hasX = true;
                    }
                    if (p.left.val == y) {
                        fa = p;
                        hasY = true;
                    }
                }
                if (p.right != null) {
                    t.add(p.right);
                    if (fa != p && p.right.val == x) {
                        hasX = true;
                    }
                    if (fa != p && p.right.val == y) {
                        hasY = true;
                    }
                }
            }
            if (hasX && hasY) {
                return true;
            }
            q = t;
        }

        return false;
    }
}
