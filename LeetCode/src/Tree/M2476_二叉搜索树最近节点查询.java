package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/02/24，2025/05/01
 * @file M2476_二叉搜索树最近节点查询.java
 * <p>
 * 思路
 * 二分 -- O(log_n)
 * 核心：对二叉搜索树的中序遍历，记录 val 得到的是一个递增序列
 * 类似Q530
 * <p>
 * 注意处理相等的情况
 */
public class M2476_二叉搜索树最近节点查询 {
    private List<Integer> li = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        int n = li.size();
        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries) {
            int j = binarySearch(0, n - 1, q);
            int mn = j < 0 ? -1 : li.get(j), mx = mn == q ? mn : j == n - 1 ? -1 : li.get(j + 1);
            res.add(Arrays.asList(mn, mx));
        }

        return res;
    }

    private void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);
        li.add(cur.val);
        inorder(cur.right);
    }

    private int binarySearch(int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (li.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}
