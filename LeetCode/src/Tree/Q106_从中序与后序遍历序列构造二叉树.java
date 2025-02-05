package Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/03/06
 * <p>
 * 1. 递归 -- O(n)
 * 2. 迭代 -- O(n)
 * 来自官解：迭代法的实现基于以下两点发现
 * 如果将中序遍历反序，则得到反向的中序遍历，即每次遍历右孩子，再遍历根节点，最后遍历左孩子。
 * 如果将后序遍历反序，则得到反向的前序遍历，即每次遍历根节点，再遍历右孩子，最后遍历左孩子。
 * 「反向」的意思是交换遍历左孩子和右孩子的顺序，即反向的遍历中，右孩子在左孩子之前被遍历。
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

    private TreeNode build(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        int idx = idxMap.get(rootVal);
        postIdx--;

        root.right = build(idx + 1, inRight);
        root.left = build(inLeft, idx - 1);

        return root;
    }

    private void init2(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postIdx = postorder.length - 1;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        init2(inorder, postorder);
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        Deque<TreeNode> stk = new LinkedList<>();

        stk.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stk.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stk.push(node.right);
            } else {
                while (!stk.isEmpty() && stk.peek().val == inorder[inorderIndex]) {
                    node = stk.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stk.push(node.left);
            }
        }

        return root;
    }
}
