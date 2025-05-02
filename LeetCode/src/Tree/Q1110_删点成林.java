package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/05/02
 * @file Q1110_删点成林.java
 * <p>
 * 思路
 * dfs
 * 类似Q1080
 * 开一个set记录所有需要删除的节点值，查询是 O(1) 的
 * 后序遍历，则对于每一个子树
 * 先处理叶子节点，再处理子树的根节点
 */
public class Q1110_删点成林 {
    private Set<Integer> st = new HashSet<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return null;
        }
        for (int x : to_delete) {
            st.add(x);
        }
        root = postorder(root);
        if (root != null) {
            res.add(root);
        }

        return res;
    }

    private TreeNode postorder(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        cur.left = postorder(cur.left);
        cur.right = postorder(cur.right);
        if (!st.contains(cur.val)) {
            return cur;
        }
        if (cur.left != null) {
            res.add(cur.left);
        }
        if (cur.right != null) {
            res.add(cur.right);
        }

        return null;
    }
}
