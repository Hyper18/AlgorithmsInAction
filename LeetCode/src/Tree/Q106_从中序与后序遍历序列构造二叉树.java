package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/03/06
 * <p>
 * 1. 递归 -- O(n)
 */
public class Q106_从中序与后序遍历序列构造二叉树 {
    private int[] inorder;
    private int[] postorder;
    private int postIdx;
    private Map<Integer, Integer> idxMap;

    private void init(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postIdx = postorder.length - 1;
        idxMap = new HashMap<>();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        init(inorder, postorder);

        int idx = 0;
        for (int val : inorder) {
            idxMap.put(val, idx++);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        int idx = idxMap.get(rootVal);
        postIdx--;

        root.right = build(idx + 1, inorderRight);
        root.left = build(inorderLeft, idx - 1);

        return root;
    }
}
