package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/02/22，2025/05/01
 * @file M889_根据前序和后序遍历构造二叉树.java
 * <p>
 * 思路
 * dfs -- O(n)
 * <p>
 * 注意处理叶子节点的情况
 */
public class M889_根据前序和后序遍历构造二叉树 {
    private int[] preorder;
    private Map<Integer, Integer> mp = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(postorder[i], i);
        }

        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int preL, int preR, int postL, int postR) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        if (preL == preR) {
            return root;
        }
        int postRoot = mp.get(preorder[preL + 1]), lenL = postRoot - postL + 1;
        root.left = build(preL + 1, preL + lenL, postL, postRoot);
        root.right = build(preL + lenL + 1, preR, postRoot + 1, postR - 1);

        return root;
    }
}
