package Tree;

/**
 * @author Hyperspace
 * @date 2024/04/24
 * @file M2385_感染二叉树需要的总时间.java
 * <p>
 * 思路
 * dfs求树的直径
 * 算根到start的距离d和树高h
 * ans = max(h - d, h + d)
 */
public class M2385_感染二叉树需要的总时间 {
    int ans = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    private int[] dfs(TreeNode cur, int start) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(cur.left, start), r = dfs(cur.right, start);
        int ll = l[0], ls = l[1], rl = r[0], rs = r[1];
        if (cur.val == start) {
            ans = Math.max(ll, rl);
            return new int[]{1, 1};
        }
        if (ls == 1 || rs == 1) {
            ans = Math.max(ans, ll + rl);
            return new int[]{(ls == 1 ? ll : rl) + 1, 1};
        }

        return new int[]{Math.max(ll, rl) + 1, 0};
    }
}
