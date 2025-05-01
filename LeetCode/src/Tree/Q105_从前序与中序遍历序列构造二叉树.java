package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/02/18，2025/05/01
 * <p>
 * 思路
 * dfs + hash -- O(n^2)
 * 记录中序遍历的 (val,idx) 对应关系 -- 查询是 O(1) 的
 * 左闭右闭写法
 */
public class Q105_从前序与中序遍历序列构造二叉树 {
    private int[] preorder;
    private Map<Integer, Integer> mp = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }

        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int inRoot = mp.get(root.val), lenL = inRoot - inL;
        root.left = build(preL + 1, preL + lenL, inL, inRoot - 1);
        root.right = build(preL + lenL + 1, preR, inRoot + 1, inR);

        return root;
    }
}
