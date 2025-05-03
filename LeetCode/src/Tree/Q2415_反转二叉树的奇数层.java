package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q2415_反转二叉树的奇数层.java
 * <p>
 * 思路
 * bfs
 * 反转奇数层节点的值
 */
public class Q2415_反转二叉树的奇数层 {
    public TreeNode reverseOddLevels1_0(TreeNode root) {
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            List<TreeNode> t = new ArrayList<>();
            List<Integer> li = new ArrayList<>();
            for (TreeNode p : q) {
                if (p.left != null) {
                    t.add(p.left);
                    li.add(p.left.val);
                }
                if (p.right != null) {
                    t.add(p.right);
                    li.add(p.right.val);
                }
            }
            if (flag) {
                Collections.reverse(li);
                int n = t.size();
                for (int i = 0; i < n; i++) {
                    t.get(i).val = li.get(i);
                }
            }
            q = t;
            flag = !flag;
        }

        return root;
    }

    public TreeNode reverseOddLevels1_1(TreeNode root) {
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            List<TreeNode> t = new ArrayList<>();
            for (TreeNode p : q) {
                if (p.left != null) {
                    t.add(p.left);
                }
                if (p.right != null) {
                    t.add(p.right);
                }
            }
            if (flag) {
                int n = q.size();
                for (int i = 0; i < n / 2; i++) {
                    int tmp = q.get(i).val;
                    q.get(i).val = q.get(n - 1 - i).val;
                    q.get(n - 1 - i).val = tmp;
                }
            }
            q = t;
            flag = !flag;
        }

        return root;
    }
}
