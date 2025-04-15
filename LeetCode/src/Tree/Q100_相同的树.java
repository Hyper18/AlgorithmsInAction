package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hyper
 * @date 2025/04/15
 * @file Q100_相同的树.java
 * <p>
 * 思路
 * 1. 向下dfs
 * 2. bfs
 * <p>
 * 注：ArrayDeque不允许null值
 */
public class Q100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        Deque<TreeNode> qp = new LinkedList<>(), qq = new LinkedList<>();
        qp.offer(p);
        qq.offer(q);
        while (!qp.isEmpty() && !qq.isEmpty()) {
            TreeNode sp = qp.poll(), sq = qq.poll();
            if (sp == null && sq == null) {
                continue;
            }
            if ((sp == null || sq == null) || sp.val != sq.val) {
                return false;
            }
            qp.offer(sp.left);
            qq.offer(sq.left);
            qp.offer(sp.right);
            qq.offer(sq.right);
        }

        return true;
    }
}
