package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2024/02/24
 * @file M2476_二叉搜索树最近节点查询.java
 * <p>
 * 思路
 * 在二叉搜索树上面进行中序遍历得到有序数组，再二分查找
 * 这样做事件复杂度才为O(log(n))
 * 否则不平衡时最差时间复杂度是O(n)
 * <p>
 * 待回看
 */
public class M2476_二叉搜索树最近节点查询 {
    List<Integer> nums = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.size();
        for (int q : queries) {
            List<Integer> li = new ArrayList<>();
            int min = -1, max = -1;

            int idxMin = binarySearch(n, q);
            if (idxMin != -1) {
                min = nums.get(idxMin);
            }
            li.add(min);

            if (min == q) {
                max = min;
            } else {
                if (idxMin != n - 1) {
                    max = nums.get(idxMin + 1);
                }
            }
            li.add(max);

            res.add(li);
        }

        return res;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        nums.add(cur.val);
        dfs(cur.right);
    }

    private int binarySearch(int n, int target) {
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
