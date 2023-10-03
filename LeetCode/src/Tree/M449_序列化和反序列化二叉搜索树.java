package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2023/09/04
 * @file M449_序列化和反序列化二叉搜索树.java
 * <p>
 * 思路
 * serialize()：先序遍历
 * deserialize(): 建树
 * <p>
 * 注意空值情况
 */
public class M449_序列化和反序列化二叉搜索树 {
    final int INF = 0x3f3f3f3f;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> li = new ArrayList<>();
        preorder(root, li);
        StringBuilder sb = new StringBuilder();
        int n = li.size();
        for (int i = 0; i < n; i++) {
            sb.append(li.get(i));
            if (i == n - 1) {
                break;
            }
            sb.append(",");
        }
        return sb.toString();
    }

    void preorder(TreeNode t, List<Integer> li) {
        if (t != null) {
            li.add(t.val);
            preorder(t.left, li);
            preorder(t.right, li);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        int[] nums = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            q.offer(num);
        }

        return build(q, -INF, INF);
    }

    TreeNode build(Queue<Integer> q, int l, int r) {
        if (q.isEmpty() || q.peek() < l || q.peek() > r) {
            return null;
        }
        int val = q.poll();
        TreeNode root = new TreeNode(val);
        root.left = build(q, l, val);
        root.right = build(q, val, r);

        return root;
    }
}
