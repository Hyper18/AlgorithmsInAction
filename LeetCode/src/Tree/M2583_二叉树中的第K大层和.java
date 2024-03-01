package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2024/02/23
 * @file M2583_二叉树中的第K大层和.java
 * <p>
 * 思路
 * bfs
 * 从根节点依次层次遍历，收集每层和
 * 若k超过树深的值，返回-1
 * 否则降序排序，返回第k大的结果
 * <p>
 * 注意爆int
 */
public class M2583_二叉树中的第K大层和 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> levelSums = new PriorityQueue<>(Collections.reverseOrder());
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            long sum = 0;
            List<TreeNode> levelNodes = new ArrayList<>(q);
            q.clear();
            for (TreeNode cur : levelNodes) {
                sum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            levelSums.add(sum);
        }
        int n = levelSums.size();
        if (k > n) {
            return -1;
        }

        while (k-- > 1) {
            levelSums.poll();
        }
        return levelSums.poll();
    }

    public long kthLargestLevelSum2(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            long sum = 0;
            List<TreeNode> levelNodes = new ArrayList<>(q);
            q.clear();
            for (TreeNode cur : levelNodes) {
                sum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            levelSums.add(sum);
        }
        int n = levelSums.size();
        if (k > n) {
            return -1;
        }
        Collections.sort(levelSums);

        return levelSums.get(n - k);
    }
}
