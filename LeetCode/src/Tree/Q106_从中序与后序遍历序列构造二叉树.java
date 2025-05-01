package Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/03/06，2024/02/21，2025/05/01
 * <p>
 * 1. dfs + hash -- O(n)
 * 2. bfs -- O(n)
 * 交换左、右孩子的遍历顺序，先右后左
 * 将中序遍历反序，右-根-左
 * 将后序遍历反序，根-右-左
 */
public class Q106_从中序与后序遍历序列构造二叉树 {
    private int[] postorder;
    private Map<Integer, Integer> mp = new HashMap<>();

    public TreeNode buildTree1_0(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }

        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int inL, int inR, int postL, int postR) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);
        int inRoot = mp.get(root.val), lenL = inRoot - inL;
        root.left = build(inL, inRoot - 1, postL, postL + lenL - 1);
        root.right = build(inRoot + 1, inR, postL + lenL, postR - 1);

        return root;
    }

    private int postIdx;

    public TreeNode buildTree1_1(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int n = inorder.length;
        postIdx = n - 1;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }

        return build1_1(0, n - 1);
    }

    private TreeNode build1_1(int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIdx--]);
        int inRoot = mp.get(root.val);
        // 注意次序
        root.right = build1_1(inRoot + 1, inR);
        root.left = build1_1(inL, inRoot - 1);

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);
        Deque<TreeNode> stk = new LinkedList<>();
        stk.push(root);
        for (int inIdx = n - 1, i = inIdx - 1; i >= 0; i--) {
            TreeNode cur = stk.peek();
            if (cur.val != inorder[inIdx]) {
                cur.right = new TreeNode(postorder[i]);
                stk.push(cur.right);
            } else {
                while (!stk.isEmpty() && stk.peek().val == inorder[inIdx]) {
                    cur = stk.pop();
                    inIdx--;
                }
                cur.left = new TreeNode(postorder[i]);
                stk.push(cur.left);
            }
        }

        return root;
    }
}
