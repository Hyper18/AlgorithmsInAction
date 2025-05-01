package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/05/01
 * @file Q501_二叉搜索树中的众数.java
 * <p>
 * 思路
 * 1. 中序遍历 + hash
 * 2. 空间优化
 */
public class Q501_二叉搜索树中的众数 {
    private Map<Integer, Integer> mp = new HashMap<>();
    private int cnt;

    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer> li = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (cnt == e.getValue()) {
                li.add(e.getKey());
            }
        }

        return li.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);
        int t = mp.merge(cur.val, 1, Integer::sum);
        cnt = Math.max(cnt, t);
        inorder(cur.right);
    }

    private int mx, preVal = -1;
    private List<Integer> li = new ArrayList<>();

    public int[] findMode2(TreeNode root) {
        inorder2(root);
        int[] res = new int[li.size()];
        int i = 0;
        for(int val : li) {
            res[i++] = val;
        }

        return res;
    }

    private void inorder2(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder2(cur.left);
        if (preVal != cur.val) {
            cnt = 1;
            preVal = cur.val;
        } else {
            cnt++;
        }
        if (cnt > mx) {
            li.clear();
            li.add(cur.val);
            mx = cnt;
        } else if (cnt == mx) {
            li.add(cur.val);
        }
        inorder2(cur.right);
    }
}
