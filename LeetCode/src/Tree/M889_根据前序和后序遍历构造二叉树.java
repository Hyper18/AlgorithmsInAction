package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/02/22
 * @file M889_根据前序和后序遍历构造二叉树.java
 * <p>
 * 思路
 * 1. 递归 -- O(n)
 * 问题划分为：
 * 根据左子树节点的前序遍历与后序遍历数组构造二叉树
 * 根据右子树节点的前序遍历与后序遍历数组构造二叉树
 */
public class M889_根据前序和后序遍历构造二叉树 {
    private int[] preorder;
    private int[] postorder;
    private Map<Integer, Integer> postMap;

    private void init(int[] inorder, int[] postorder) {
        this.preorder = inorder;
        this.postorder = postorder;
        postMap = new HashMap<>();
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        init(preorder, postorder);
        for (int i = 0; i < n; i++) {
            postMap.put(postorder[i], i);
        }

        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        int leftCount = 0;
        if (preLeft < preRight) {
            leftCount = postMap.get(preorder[preLeft + 1]) - postLeft + 1;
        }

        return new TreeNode(preorder[preLeft],
                build(preLeft + 1, preLeft + leftCount, postLeft, postLeft + leftCount - 1),
                build(preLeft + leftCount + 1, preRight, postLeft + leftCount, postRight - 1));
    }
}
